/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.BookBrain;

import Model.BinarySearch;
import Model.Entities.Book;
import Model.Entities.Student;
import Model.Search;
import Model.StudentBrain.StudentFactory;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class BookRecord {
    private static HashMap<Student, Book> borrowList = new HashMap<Student, Book>();
    private static HashMap<Student, Book> returnList = new HashMap<Student, Book>();
    
    
    public void borrowBook(Student student, Book book){
        Search sStudent = new BinarySearch();
        
        StudentFactory sFC = new StudentFactory();
        List<Student> sL = sFC.sortedStudentList();
        
        if(sStudent.binarySearch(sL, student.toString(), 0, sL.size() - 1) != -1) {
            borrowList.put(student, book);
            System.out.println("Student: " + student.toString() + " and the book: " + book.getTitle() + " successfully registered to borrow list.");
        } else {
            System.out.println("Student has not registered in the system.");
        }
    }
    
    public void returnBook(Student student, Book book) {
        
    }

    public static HashMap<Student, Book> getBorrowList() {
        return borrowList;
    }

    public static HashMap<Student, Book> getReturnList() {
        return returnList;
    }
    
    
}
