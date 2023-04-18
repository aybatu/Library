/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Menu;

import Controller.Queue.QueueController;
import Utils.Constant;
import Utils.Utils;

/**
 *
 * @author aybatukerkukluoglu
 */
public class ReturnBookController {

    //PROPERTIES
    //Utils object stored in 'u' constant
    private final Utils u = new Utils();
    //Text file name constant
    private static final String fileName = "borrowList.txt";

    /**
     * Empty constructor.
     */
    public ReturnBookController() {

    }

    /**
     * Records return book information
     */
    public void returnBook() {
        //byStudentName set false searching is set for student id
        Constant.StudentSearch.byStudentName = false;
        //byAuthor set false searching is set for book title
        Constant.BookSearch.byAuthor = false;

        // Request for the student id information
        String studentID = u.getString("Please enter the StudentID.");
        // Request for the book title to return information.
        String bookTitle = u.getString("Please enter book title.");
        //Information is found = true, information is not found false.
        boolean bookStatus = returnBook(studentID, bookTitle);
        //If bookStatus is true
        if (bookStatus) {
            //New SearchStudentMenyController object
            SearchStudentSubMenuController sSMC = new SearchStudentSubMenuController();
            //New SearchBookMenuController object
            SearchBookMenuController sBMC = new SearchBookMenuController();
            //searchStudentId searches for the student id and print information of student.
            sSMC.searchStudentID(studentID);
            //searchBookRequest searches for the book title and prints information of the book.
            sBMC.searchBookRequest(bookTitle);
            //informs user return of book done successfully.
            System.out.println("The information of return successfuly recorded into system. Thank you.\n");
            //Checks queue list if there is any student waits for the book.
            checkQueue(bookTitle);
        }

    }

    /**
     * Takes information of the book and student, and after data is found
     * information is removed from the borrow list file.
     *
     * @param studentID String ID of the student
     * @param bookTitle String title of the book
     * @return Boolean if the return is successful.
     */
    private boolean returnBook(String studentID, String bookTitle) {
        //finds student id and book title in the data file
        boolean status = u.removeLine(ReturnBookController.fileName, studentID + " " + bookTitle);
        if (status) {
            //if the remove is true updates borrow list
            BorrowBookMenuController bBMC = new BorrowBookMenuController();
            bBMC.updateBorrowList();
            return status;
        } else {
            //if could not find the data informs user.
            System.out.println("Either book or student information is wrong. Book return could not be registered.");
            return status;
        }
    }

    /**
     * Searches for the book title in the queue list, and if student is found
     * adds to borrowList.
     *
     * @param studentID String book title.
     */
    private void checkQueue(String bookTitle) {
        //New QueueController object.
        QueueController qC = new QueueController();
        //New BorrowBookMenyController object.
        BorrowBookMenuController bBMC = new BorrowBookMenuController();
        //updates queue list before checking the list.
        qC.prepareQueue();

        //If book title search is true
        if (qC.queueSearch(bookTitle)) {
            //Gets student ID who waits for the book and it is stored into studentIDQueue.
            String studentIDQueue = qC.getStudentID();
            //new SearchStudentSubMenuController object.
            SearchStudentSubMenuController sSSMC = new SearchStudentSubMenuController();
            //Informs user for the coming information.
            System.out.println("Student on the below information waits for the book please infrom the student. His information recorded into borrow list.");
            //searches for student id in studentlist and provides full information of the student.
            sSSMC.searchStudentID(studentIDQueue);
            //searches for the book title in the book list and provides full information of the book.
            bBMC.borrowBook(studentIDQueue, bookTitle);
        }

    }
}
