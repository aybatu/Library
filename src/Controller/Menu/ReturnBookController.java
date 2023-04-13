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
    private Utils u = new Utils();
    private static int bTIndex = 1;
    private static int iDIndex = 0;
    
    private boolean returnBook(String studentID, String bookTitle) {
        
        boolean status = u.removeLine("borrowList.txt", studentID + " " + bookTitle);
        if(status){
            BorrowBookMenuController bBMC = new BorrowBookMenuController();
            bBMC.updateBorrowList();
            return status;
        }else{
            System.out.println("Either book or student information is wrong. Book return could not be registered.");
            return status;
        }
    }
    
    public void returnBook() {
        Constant.StudentSearch.byStudentName = false;
            Constant.BookSearch.byAuthor = false;
            QueueController qC = new QueueController();
            ReturnBookController rBC = new ReturnBookController();
            BorrowBookMenuController bBMC = new BorrowBookMenuController();
            String studentID = u.getString("Please enter the StudentID.");
            String bookTitle = u.getString("Please enter book title.");
            boolean bookStatus = rBC.returnBook(studentID, bookTitle);

            if (bookStatus) {
                SearchStudentSubMenuController sSMC = new SearchStudentSubMenuController();
                SearchBookMenuController sBMC = new SearchBookMenuController();
                sSMC.searchStudentID(studentID);
                sBMC.searchBookRequest(bookTitle);
                System.out.println("The information of return successfuly recorded into system. Thank you.\n");
                qC.prepareQueue();
                if (qC.queueSearch(bookTitle)) {

                    String studentIDQueue = qC.getStudentID();

                    SearchStudentSubMenuController sSSMC = new SearchStudentSubMenuController();
                    System.out.println("Student on the below information waits for the book please infrom the student. His information recorded into borrow list.");
                    sSSMC.searchStudentID(studentIDQueue);

                    bBMC.borrowBook(studentIDQueue, bookTitle);
                }

            }
    }
}
