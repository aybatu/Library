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
 *
 * @author aybatukerkukluoglu
 */
public enum ListBookSubMenu {
    ORDERBYAUTHOR {
        @Override
        public void prompt() {
            Constant.BookSearch.byAuthor = true;
            
            List<Book> bookList= bF.sortedBookList();
            sMC.showBookListInfo(bookList);
        }
    },
    ORDERBYTITLE {
        @Override
        public void prompt() {
            Constant.BookSearch.byAuthor = false;
            
            List<Book> bookList= bF.sortedBookList();
            sMC.showBookListInfo(bookList);
        }
    },
    EXIT{
        @Override
        public void prompt() {
            System.out.println("You are redirecting back to main menu...");
        
        }
    };
    
    SubMenuController sMC = new SubMenuController();
    BookFactory bF = new BookFactory();
    public abstract void prompt();
}
