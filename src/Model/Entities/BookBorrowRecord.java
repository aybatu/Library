/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author aybatukerkukluoglu
 */
public class BookBorrowRecord {
    private Student student;
    private Book book;
    private String date;
    
    public BookBorrowRecord(Student student, Book book) {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        this.book = book;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }

    public String getDate() {
        return date;
    }
    
    
    @Override
    // if both the object references are
    // referring to the same object.
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        // type casting of the argument.
        BookBorrowRecord other = (BookBorrowRecord) obj;

        // comparing the state of argument with
        // the state of 'this' Object
        if (student.getId() != other.student.getId()) {
            return false;
        }
        if (book.getId() == other.book.getId()) {

            if (!book.getId().equals(other.book.getId())) {
                return false;
            }
        }

        return true;

    }
    
     @Override
    public int hashCode() {
     
        Matcher m = Pattern.compile("[0-9]").matcher(book.getId());
        int r = 0;
        while (m.find()) {
            r += Integer.parseInt(m.group());
            
        }
         
        return book.getAuthor().length() + r + book.getTitle().length();

    }
        
}
