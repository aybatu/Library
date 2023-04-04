/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library.ca1;

import Model.BinarySearch;
import Model.BookBrain.BookFactory;
import Model.BookBrain.BookRecord;
import Model.Entities.Book;
import Model.Entities.Student;
import Model.StudentBrain.StudentFactory;
import Utils.Utils;
import View.MainMenu;
import java.util.Map;

/**
 *
 * @author aybatukerkukluoglu
 */
public class LibraryCA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        BookFactory bFC = new BookFactory();
//        int i = 0;
//        for (Book t : bFC.sortedBookList()) {
//            i++;
//            System.out.println(i + " " + t.toString());
//        }
//
//        BinarySearch binarySearch = new BinarySearch();
//
//        System.out.println(binarySearch.binarySearch(bFC.sortedBookList(), "Zorana Klais", 0, bFC.sortedBookList().size() - 1));
//
//        StudentFactory sF = new StudentFactory();
//        int j = 0;
//        for (Student s : sF.sortedStudentList()) {
//            j++;
//            System.out.println(j + " " + s.getFirstName() + s.getLastName() + s.getAddress());
//        }
//
//        System.out.println(binarySearch.binarySearch(sF.sortedStudentList(), "Martina Alvarez", 0, sF.sortedStudentList().size() - 1));
//        
//        Book book = bFC.sortedBookList().get(1);
//        Student student = sF.sortedStudentList().get(1);
//        
//        BookRecord newBR = new BookRecord();
//        newBR.borrowBook(student, book);
//        
//        for(Map.Entry m:BookRecord.getBorrowList().entrySet()) {
//            Book b = (Book)m.getValue();
//            System.out.println("Student: " + m.getKey() + " Book: " + b.getTitle());
//            
//        }
        Utils utils = new Utils();
       
        MainMenu[] mM = MainMenu.values();
        boolean exit = true;

        do {
            int userInput = utils.getUserIntBetween("Please select item you would like to query.", 1, mM.length) - 1;
            
            switch (mM[userInput]) {
                case SEARCHBOOK:
                    mM[userInput].printRequest();
            }
             
        } while (exit);
    }

}
