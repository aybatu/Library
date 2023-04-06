/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Menu;

import Controller.Book.BookFactory;
import Controller.SearchAlgorithms;
import Controller.Student.StudentFactory;
import Model.Entities.BookBorrowRecord;
import Utils.Utils;
import java.util.HashSet;

/**
 *
 * @author aybatukerkukluoglu
 */
public class BorrowBookMenuController {

    private static HashSet<BookBorrowRecord> bookSet = new HashSet<>();
    private SearchAlgorithms bS = new SearchAlgorithms();
    private BookFactory bF = new BookFactory();
    private StudentFactory sF = new StudentFactory();
    private Utils iU = new Utils();
    private static boolean isStudentValid;
    private static boolean isBookValid;

    /**
     * Request a prompt user to enter an ID for student.
     * @param prompt String student ID.
     */
    public void requestStudentID(String prompt) {

        //Book title request
        String student = iU.getString(prompt);
        //Called method searches for the book name through the book list.
        checkForStudent(student);
    }

    /**
     * Request a book title to search through book list.
     * @param prompt information to prompt user for request. 
     */
    public void requestBookTitle(String prompt) {

        //Book title request
        String book = iU.getString(prompt);
        //Called method searches for the book name through the book list.
        checkForBook(book);
    }

    /**
     * Checks for student ID if its valid or not
     * @param studentID string Student ID 
     */
    private void checkForStudent(String studentID) {
        //Does binary search for student ID
        if (searchForStudent(studentID) == -1) {//if binarySearch return is -1 student is not registered.
            //if student id is not registered in library system inform user.
            System.out.println("Sorry, student registration cannot be found in the system.");
            //isStudentValid set false
            isStudentValid = false;
        } else {
            //Student is valid informs user
            System.out.println("Student found in the system successfully.");
            //isStuendtValid set true
            isStudentValid = true;
        }

    }

    /**
     * Checks for a book if its in library or not.
     * @param bookTitle String book title to search
     */
    private void checkForBook(String bookTitle) {
        //Does binary search for the book title.
        if (searchForBook(bookTitle) == -1) {//if binarySearch return is -1 book is not valid
            //inform user for the status of book
            System.out.println("The library does not have that book registered in the system.");
            //isBookValid set false
            isBookValid = false;
        } else {
            //Inform users book is valid
            System.out.println("The book found in the system successfully.");
            //isBookValid set true
            isBookValid = true;
        }

    }

    public boolean borrowBook(int book, int student) {
        BookBorrowRecord bBR = new BookBorrowRecord(sF.sortedStudentList().get(student), bF.sortedBookList().get(book));
        if (!bookSet.add(bBR)) {
            System.out.println("The book is already borrowed by another student. Would you like to add student to queue for the book?");
            return false;
        } else {
            bookSet.add(bBR);
            System.out.println("Book borrow registration successfully completed.");
            return true;
        }

    }

    /**
     * Search for a student.
     * @param studentID String student ID to search.
     * @return student index if cannot found -1.
     */
    private int searchForStudent(String studentID) {

        return bS.binarySearch(sF.sortedStudentList(), studentID, 0, sF.sortedStudentList().size() - 1);
    }

    /**
     * Search for a book.
     * @param bookTitle String book title to search.
     * @return book index if cannot found -1.
     */
    private int searchForBook(String bookTitle) {

        return bS.binarySearch(bF.sortedBookList(), bookTitle, 0, bF.sortedBookList().size() - 1);
    }

}
