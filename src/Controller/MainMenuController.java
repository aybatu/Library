/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BinarySearch;
import Model.BookBrain.BookFactory;
import Model.Entities.Book;
import Utils.Utils;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class MainMenuController {
    /**
     * Request a book title to search through book list.
     */
    public void requestBookName() {
        //new Utils object
        Utils iU = new Utils();
        //Book title request
        String bookName = iU.getString("Please enter book title you would like to search.");
        //Called method searches for the book name through the book list.
        searchBookRequest(bookName);
    }
    
    /**
     * It is used for binary search through the created book array list.
     * @param bookTitle String book title to search
     */
    private void searchBookRequest(String bookTitle) {
        //new binarysearch object.
        BinarySearch bS = new BinarySearch();
        //new book factory
        BookFactory bFC = new BookFactory();
        //new sorted book array list stored in bookList variable.
        List<Book> bookList = bFC.sortedBookList();
        
        //Requested book index stored in bookIndex
        int bookIndex = bS.binarySearch(bookList, bookTitle, 0, bookList.size() - 1);
        
        if(bookIndex == -1) {
            System.out.println("Sorry, we could not found "+bookTitle+"in the library.");
        } else {
            System.out.println("Followed information for the book bellow:");
            System.out.println("Book ID: "+bookList.get(bookIndex).getId());
            System.out.println("Book Author: "+bookList.get(bookIndex).getAuthor());
            System.out.println("Book Title: "+bookList.get(bookIndex).getTitle());
        }
    }
}
