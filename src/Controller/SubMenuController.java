/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entities.Book;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class SubMenuController {

    public void showBookListInfo(List<Book> bookList) {
        for(Book b: bookList) {
            System.out.println("Followed information for the book bellow:");
            System.out.println("Book ID: "+b.getId());
            System.out.println("Book Author: "+b.getAuthor());
            System.out.println("Book Title: "+b.getTitle());
        }
    }
}
