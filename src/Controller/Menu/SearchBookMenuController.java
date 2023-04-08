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
import Utils.Utils;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class SearchBookMenuController {

    //PROPERTIES
    //new binarysearch object.
    private SearchAlgorithms bS = new SearchAlgorithms();
    //new Utils object
    Utils iU = new Utils();

    /**
     * Request a book title to search through book list.
     * @param prompt Prompts information for the user
     */
    public void requestBookTitle(String prompt) {

        //Book title request
        String book = iU.getString(prompt);
        //Called method searches for the book name through the book list.
        searchBookRequest(book);
    }

    /**
     * It is used for binary search through the created book array list.
     *
     * @param bookInfo String book title or the author to search
     */
    public void searchBookRequest(String bookInfo) {

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
            System.out.println("Followed information for the book bellow:\n");
            System.out.println("Book ID: " + bookList.get(bookIndex).getId());
            System.out.println("Book Author: " + bookList.get(bookIndex).getAuthor());
            System.out.println("Book Title: " + bookList.get(bookIndex).getTitle()+"\n");
        }
    }
}
