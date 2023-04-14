/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Entities.Book;
import Model.Entities.Student;

/**
 *
 * @author aybatukerkukluoglu
 */
public class BorrowListView {
    public void borrowListView(Student s, Book b) {
        System.out.println("Followed information for the student below: ");
        System.out.println("Student ID: " + s.getId());
        System.out.println("Student name: " + s.getFirstName() + " " + s.getLastName()+"\n");
        
        System.out.println("Has borrowed the book information provided below: ");
        System.out.println("Book ID: " + b.getId());
        System.out.println("Book Title: " + b.getTitle());
        System.out.println("Book Author: " + b.getAuthor());
    }
}
