/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BinarySearch;
import Model.BookBrain.BookFactory;
import Model.Entities.Book;
import Model.Entities.Student;
import Model.StudentBrain.StudentFactory;
import Utils.Utils;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class MainMenuController {

    //PROPERTIES
    //new binarysearch object.
    private BinarySearch bS = new BinarySearch();
    //new Utils object
    Utils iU = new Utils();

    /**
     * Request a book title to search through book list.
     */
    public void requestBookTitle() {

        //Book title request
        String book = iU.getString("Please enter book title you would like to search.");
        //Called method searches for the book name through the book list.
        searchBookRequest(book);
    }

    /**
     * It is used for binary search through the created book array list.
     *
     * @param bookTitle String book title or the author to search
     */
    private void searchBookRequest(String bookInfo) {

        //new book factory
        BookFactory bFC = new BookFactory();
        //new sorted book array list stored in bookList variable.
        List<Book> bookList = bFC.sortedBookList();

        //Requested book index stored in bookIndex
        int bookIndex = bS.binarySearch(bookList, bookInfo, 0, bookList.size() - 1);

        //If book index is not found return -1.
        if (bookIndex == -1) {
            System.out.println("Sorry, we could not found " + bookInfo + " in the library.");
        } else {
            //Index is found prompts the information of the book.
            System.out.println("Followed information for the book bellow:");
            System.out.println("Book ID: " + bookList.get(bookIndex).getId());
            System.out.println("Book Author: " + bookList.get(bookIndex).getAuthor());
            System.out.println("Book Title: " + bookList.get(bookIndex).getTitle());
        }
    }

    public void showStudentInfo(List<Student> studentList) {
        for (Student s : studentList) {
            System.out.println("");
            System.out.println("Student ID: " + s.getId());
            System.out.println("Student name: " + s.getFirstName() + " " + s.getLastName());
            System.out.println("Student Address: " + s.getAddress());
        }

    }

    public void requestStudentID() {

        //Book title request
        String student = iU.getString("Please enter student ID you would like to search.");
        //Called method searches for the book name through the book list.
        searchForAStudent(student);
    }

    public void requestStudentName() {

        //Book title request
        String student = iU.getString("Please enter student full name you would like to search.");
        //Called method searches for the book name through the book list.
        searchForAStudent(student);
    }

    private void searchForAStudent(String studentInfo) {

        //new student factory
        StudentFactory sF = new StudentFactory();
        //new sorted book array list stored in bookList variable.
        List<Student> studentList = sF.sortedStudentList();

        //Requested book index stored in bookIndex
        int studentIndex = bS.binarySearch(studentList, studentInfo, 0, studentList.size() - 1);

        //If book index is not found return -1.
        if (studentIndex == -1) {
            System.out.println("Sorry, we could not found provided info: " + studentInfo + " registered in library system.");
        } else {
            //Index is found prompts the information of the book.
            showStudentInfo(studentList.get(studentIndex));

        }
    }

    public void showStudentInfo(Student student) {

        System.out.println("");
        System.out.println("Followed information for the book bellow:");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student Address: " + student.getAddress());

    }
}
