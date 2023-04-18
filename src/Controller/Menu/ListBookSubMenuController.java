/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Menu;

import Model.Entities.Book;
import Utils.Constant;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class ListBookSubMenuController {

    /**
     * Empty constructor.
     */
    public ListBookSubMenuController() {
    }

    /**
     * Prompt provided book list information
     *
     * @param bookList a book object array list
     */
    public void showBookListInfo(List<Book> bookList) {
        //simple for loop for a Book array list.
        for (Book b : bookList) {
            //prompts each book information in the list.
            System.out.println(Constant.Seprator.informationSep);
            System.out.println("Followed information for the book bellow:");
            System.out.println("Book ID: " + b.getId());
            System.out.println("Book Author: " + b.getAuthor());
            System.out.println("Book Title: " + b.getTitle()+"\n");
           
        }
    }
}
