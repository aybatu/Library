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
    
    public void requestBookName() {
        Utils iU = new Utils();
        String bookName = iU.getString("Please enter book title you would like to search.");
        
        searchBookRequest(bookName);
    }
    
    private void searchBookRequest(String bookName) {
        
        BinarySearch bS = new BinarySearch();
        
        BookFactory bFC = new BookFactory();
        List<Book> bookList = bFC.sortedBookList();
        
        int result = bS.binarySearch(bookList, bookName, 0, bookList.size() - 1);
        
        if(result == -1) {
            System.out.println("Sorry, we could not found "+bookName+"in the library.");
        } else {
            System.out.println("Followed information for the book bellow:");
            System.out.println("Book ID: "+bookList.get(result).getId());
            System.out.println("Book Author: "+bookList.get(result).getAuthor());
            System.out.println("Book Title: "+bookList.get(result).getTitle());
        }
    }
}
