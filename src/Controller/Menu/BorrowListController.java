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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class BorrowListController {

    //PROPERTIES
    //Regx pattern to separate strings
    private final static String regxPattern = " ";
    //After separation of string book title index
    private final static int bookTitleIndex = 1;
    //After separation of string student index
    private final static int studentIDIndex = 0;

    /**
     * Empty constructor.
     */
    public BorrowListController() {

    }

    /**
     * Creates a HashMap for students borrowed books
     *
     * @param fileName text file name to read as data source
     * @return Key Student Value Book HashMap object.
     */
    private HashMap<Student, Book> bookBorrowMap(String fileName) {
        //by student name set false searching is set for student ID
        Constant.StudentSearch.byStudentName = false;
        //byAuthor set false searching is set for book title
        Constant.BookSearch.byAuthor = false;
        //New file reader scanner object address stored in "fR"
        FileReaderScanner fR = new FileReaderScanner(fileName);
        //new utils object.
        Utils utils = new Utils();
        //New String List 'bookListInfo' assigned the read lines from provided txt file.
        List<String> bookListInfo = fR.readLineby();
        //New Student, Book HashMap data structer
        HashMap<Student, Book> borrowMap = new HashMap<>();
        //new searching algorithms object
        SearchAlgorithms sA = new SearchAlgorithms();
        // new book factory object
        BookFactory bF = new BookFactory();
        //new student factory object.
        StudentFactory sF = new StudentFactory();
        //Sorted book list
        List<Book> bookList = bF.sortedBookList();
        //sorted student list.
        List<Student> studentList = sF.sortedStudentList();

        //A simple for loop
        for (int i = 0; i < bookListInfo.size(); i++) {
            //String array bookInfo splited txt arrays
            String[] bookInfo = utils.strSplitter(bookListInfo.get(i), regxPattern);
            //student ID 
            String studentID = bookInfo[studentIDIndex];
            //Book title
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
            //Book index for the sorted book list.
            int bookIndex = sA.binarySearch(bookList, bT, 0, bookList.size() - 1);
            //Student index for the sorted student list.
            int studentIndex = sA.binarySearch(studentList, studentID, 0, studentList.size() - 1);
            //student object address stored in 's' variable.
            Student s = studentList.get(studentIndex);
            //book object address stored in 'b' variable
            Book b = bookList.get(bookIndex);
            //Student key and book value is put in borrowMap.
            borrowMap.put(s, b);

        }
        //returns borrowMap.
        return borrowMap;

    }

    /**
     * Shows borrow list student book information.
     *
     * @param fileName String provided data-text file name for the borrow list.
     */
    public void showBorrowList(String fileName) {
        //bookBorrowMap method called and file name passed. Return of Student, Book HashMap stored in borrowMap variable.
        HashMap<Student, Book> borrowMap = bookBorrowMap(fileName);
        //new BorrowListView object.
        BorrowListView bLV = new BorrowListView();

        //Each Student, Book entry for the Set printed within a for loop.
        for (HashMap.Entry<Student, Book> set : borrowMap.entrySet()) {
            //prints an information view within the student and book data
            bLV.borrowListView(set.getKey(), set.getValue());
        }

    }

}
