/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.SubMenuController;
import Model.BookBrain.BookFactory;
import Model.Entities.Book;
import Utils.Constant;
import java.util.List;

/**
 *Sub menu of the Book list option for the main menu.
 * @author aybatukerkukluoglu
 */
public enum ListBookSubMenu {
    ORDERBYAUTHOR {
        @Override
        /**
         * Prompts book list ordered by author name.
         */
        public void prompt() {
            //Sets byAuthor static variable to true
            Constant.BookSearch.byAuthor = true;
            
            //Gets updated book list from the file.
            List<Book> bookList= bF.sortedBookList();
            //prompts book information ordered by Author name.
            sMC.showBookListInfo(bookList);
        }
    },
    ORDERBYTITLE {
        @Override
        /**
         * Prompts book list ordered by book title.
         */
        public void prompt() {
            //Sets byAthor static variable to false.
            Constant.BookSearch.byAuthor = false;
            //Gets updated book list from the file
            List<Book> bookList= bF.sortedBookList();
            //prompts book information ordered by title
            sMC.showBookListInfo(bookList);
        }
    },
    EXIT{
        @Override
        /**
         * Redirecting back to main menu.
         */
        public void prompt() {
            System.out.println("You are redirecting back to main menu...");
        
        }
    };
    
    //new SubMenuController Object.
    private static SubMenuController sMC = new SubMenuController();
    //New BookFactory object
    private static BookFactory bF = new BookFactory();
    //Applied for all enum items.
    public abstract void prompt();
}
