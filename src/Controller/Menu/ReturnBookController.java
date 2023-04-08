/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Menu;


import Utils.Utils;

/**
 *
 * @author aybatukerkukluoglu
 */
public class ReturnBookController {
    private Utils u = new Utils();
    private static int bTIndex = 1;
    private static int iDIndex = 0;
    
    public boolean returnBook(String studentID, String bookTitle) {
        
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
}
