/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Menu;

import Controller.Book.BookFactory;
import Controller.Book.BookTitleReader;
import Controller.Queue.QueueController;
import Controller.SearchAlgorithms;
import Controller.Student.StudentFactory;
import Model.Entities.Book;
import Model.Entities.Student;
import Utils.Utils;
import Utils.WriterBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class BorrowBookMenuController {

    //PROPERTIES
    //BookTitle set
    private static HashSet<String> bookTitleSet;
    //Null SearchAlgorithms pointer.
    private final SearchAlgorithms bS;
    //Book Factory object.
    private final BookFactory bF = new BookFactory();
    //Student Factory object.
    private final StudentFactory sF = new StudentFactory();
    //QeueueController object.
    private final QueueController qC = new QueueController();
    //null bookTitleReader pointer
    private final BookTitleReader bTR;
    //Utils object.
    private final Utils iU = new Utils();
    private final static String borrowListFile = "borrowList.txt";
    //Empty student pointer
    private Student student;
    //Empty book pointer.
    private Book book;

    /**
     * BorrowBookMenyController constructor.
     */
    public BorrowBookMenuController() {
        //Creates new SearchAlgorithms object and stores in to 'bS'
        this.bS = new SearchAlgorithms();
        //Creates new BookTitleReader object and stores in to 'bTR'
        this.bTR = new BookTitleReader();

    }

    /**
     * Updates book title set object from the data text file.
     */
    public void updateBorrowList() {
        //Book title set is updated by borrow list file.
        this.bookTitleSet = bTR.bookBorrowTitleSet(borrowListFile);

    }

    /**
     * Records a borrow data for the provided student and book information.
     *
     * @return Boolean - true if information is recorded, false if there is an
     * error.
     */
    public boolean borrowBook() {
        //if student property is null
        if (student == null) {
            //sents user a request for studentid
            return requestStudentID("Please enter the student ID");
        } else if (student != null && book == null) {
            //if student is not null and book is null sends a reuqest for book title
            return requestBookTitle("Please enter the book title.");
        } else {
            //if book title is added into set
            if (bookTitleSet.add(book.getTitle().toLowerCase())) {
                //create a new writerBuffer object.
                WriterBuffer bW = new WriterBuffer();
                //create a new String List and store in borrowInfoList.
                List<String> borrowInfoList = new ArrayList<>();
                //Add student id into borrowInfoList
                borrowInfoList.add(student.getId());
                //Add book title into borrowInfoList.
                borrowInfoList.add(book.getTitle().toLowerCase());
                //Pass borrowInfoList to file writer to write into borrowlist file.
                bW.writeToFile(borrowListFile, borrowInfoList);
                //updates borrowList.
                updateBorrowList();
                //informs user for the status
                System.out.println("Student and book information successfully registered in system.\n");
                //return true.
                return true;
            } else {
                System.out.println("You are redirecting to the main menu.");
                return true;
            }
        }

    }

    /**
     * Borrows book provided studentId and book title information.
     *
     * @param sID String student id.
     * @param bTitle String book title.
     */
    public void borrowBook(String sID, String bTitle) {
        //if book is added to book title set
        if (bookTitleSet.add(bTitle)) {
            //new writerbuffer object created.
            WriterBuffer bW = new WriterBuffer();
            //new Arraylist created
            List<String> borrowInfoList = new ArrayList<>();
            //Student and book info added into the arrayList
            borrowInfoList.add(sID);
            borrowInfoList.add(bTitle);
            //info is writtten into the borrowList file.
            bW.writeToFile(borrowListFile, borrowInfoList);
            //BorrowList is updated.
            updateBorrowList();
            //information for the user.
            System.out.println("Student and book information successfully registered in system.\n");
        } else {
            //If book title is not added into borrow list set it is taken by another student.
            System.out.println("Book has been borrow by another student. Recently not in the library. Would you like to add student to waiting queue for the book?\n");
        }
    }

    /**
     * Request a prompt user to enter an ID for student.
     *
     * @param prompt String student ID.
     */
    private boolean requestStudentID(String prompt) {

        //Book title request
        String studentIDRequest = iU.getString(prompt);
        //Called method searches for the book name through the book list.
        return checkForStudent(studentIDRequest);
    }

    /**
     * Request a book title to search through book list.
     *
     * @param prompt information to prompt user for request.
     * @return boolean - if the book title exist in the system returns true.
     */
    private boolean requestBookTitle(String prompt) {

        //Book title request
        String bookTitleRequest = iU.getString(prompt);
        //Called method searches for the book name through the book list.
        return checkForBook(bookTitleRequest);
    }

    /**
     * Checks for student ID if its valid or not
     *
     * @param studentID string Student ID
     */
    private boolean checkForStudent(String studentID) {
        int studentIndex = searchForStudent(studentID);
        //Does binary search for student ID
        if (studentIndex == -1) {//if binarySearch return is -1 student is not registered.
            //if student id is not registered in library system inform user.
            System.out.println("Sorry, student registration cannot found in the system.\n");

            //isStudentValid set false
            return false;
        } else {
            student = sF.sortedStudentList().get(studentIndex);
            //Student is valid informs user
            System.out.println("Student found in the system successfully.\n");
            //isStuendtValid set true

            return true;
        }

    }

    /**
     * Checks for a book if its in library or not.
     *
     * @param bookTitle String book title to search
     */
    private boolean checkForBook(String bookTitle) {
        int bookIndex = searchForBook(bookTitle);

        updateBorrowList();
        //Does binary search for the book title.
        if (bookIndex == -1) {//if binarySearch return is -1 book is not valid
            //inform user for the status of book
            System.out.println("The library does not have that book registered in the system.\n");

            return false;
        } else if (bookTitleSet.contains(bF.sortedBookList().get(bookIndex).getTitle().toLowerCase())) {
            book = bF.sortedBookList().get(bookIndex);
            System.out.println("Book is not in the library recently. Borrowed by another student.");

            qC.addQueue(student.getId(), book.getTitle().toLowerCase());

            return true;
        } else {
            book = bF.sortedBookList().get(bookIndex);
            //Inform users book is valid
            System.out.println("The book found in the system successfully.\n");
            return true;
        }

    }

    /**
     * Search for a student.
     *
     * @param studentID String student ID to search.
     * @return student index if cannot found -1.
     */
    private int searchForStudent(String studentID) {

        return bS.binarySearch(sF.sortedStudentList(), studentID, 0, sF.sortedStudentList().size() - 1);
    }

    /**
     * Search for a book.
     *
     * @param bookTitle String book title to search.
     * @return book index if cannot found -1.
     */
    private int searchForBook(String bookTitle) {

        return bS.binarySearch(bF.sortedBookList(), bookTitle, 0, bF.sortedBookList().size() - 1);
    }

}
