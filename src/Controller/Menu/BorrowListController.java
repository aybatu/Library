/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Menu;

import Controller.Book.BookFactory;
import Controller.SearchAlgorithms;
import Controller.Student.StudentFactory;
import Model.Entities.Book;
import Model.Entities.Student;
import Utils.Constant;
import Utils.FileReaderScanner;
import Utils.Utils;
import View.BorrowListView;
import static java.lang.reflect.Array.set;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aybatukerkukluoglu
 */
public class BorrowListController {
    private static String regxPattern = " ";
    private static int bookTitleIndex = 1;
    private static int studentIndex = 0;
    
    
    
    
    private HashMap<Student,Book> bookBorrowMap(String fileName) {
        Constant.StudentSearch.byStudentName = false;
        Constant.BookSearch.byAuthor = false;
        //New file reader scanner object address stored in "fR"
        FileReaderScanner fR = new FileReaderScanner(fileName);
        //new utils object.
        Utils utils = new Utils();
        //New String List 'bookListInfo' assigned the read lines from provided txt file.
        List<String> bookListInfo = fR.readLineby();
        //New Book object array with the size of bookListInfo list
        HashMap<Student, Book> borrowMap = new HashMap<>();
        
        SearchAlgorithms sA = new SearchAlgorithms();
        BookFactory bF = new BookFactory();
        StudentFactory sF = new StudentFactory();
        
        List<Book> bookList = bF.sortedBookList();
        List<Student> studentList = sF.sortedStudentList();

        //A simple for loop
        for (int i = 0; i < bookListInfo.size(); i++) {
            //String array bookListInfo splited txt arrays
            String[] bookInfo = utils.strSplitter(bookListInfo.get(i), regxPattern);
            String studentID = bookInfo[studentIndex];
            String bT = "";
            //A simple for loop checks for the rest of the indexes of bookInfo array.
            for (int j = bookTitleIndex; j < bookInfo.length; j++) {
                //If the index of the array is last one addes it to 'bT' without a space.
                if (j == bookInfo.length - 1) {
                    bT += bookInfo[j].trim();
                } else {//else addes the string in the index to 'bT' with a space.
                    bT += bookInfo[j].trim() + " ";
                }
            }
            
            int bookIndex = sA.binarySearch(bookList, bT, 0, bookList.size() - 1);
            int studentIndex = sA.binarySearch(studentList, studentID, 0, studentList.size() - 1);
            
            Student s = studentList.get(studentIndex);
            Book b = bookList.get(bookIndex);
            
            borrowMap.put(s, b);
            
        }
        //returns bookArr.
        return borrowMap;

    }
    
    public void showBorrowList(String fileName) {
        HashMap<Student, Book> borrowMap = bookBorrowMap(fileName);
        
        BorrowListView bLV = new BorrowListView();
        
        for(HashMap.Entry<Student, Book> set: borrowMap.entrySet()) {
           
                    bLV.borrowListView(set.getKey(), set.getValue());
        }
        
    }

}
