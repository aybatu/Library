/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.MainMenuController;
import Utils.Constant;
import Utils.Utils;

/**
 * Main Menu Options.
 *
 * @author aybatukerkukluoglu
 */
public enum MainMenu {
    /**
     * Request book name and searches for the book through the book list.
     */
    SEARCHBOOK {
        @Override
        public void printRequest() {
            //byAuthor static variable must be set false since search will be for the title.
            Constant.BookSearch.byAuthor = false;
            //Request a book name to search.
            mMC.requestBookTitle();

        }
    },
    /**
     * Lists all books in the library.
     */
    LISTBOOKS {
        @Override
        public void printRequest() {
            //ListBookSubMenu enum items stored in lBSM
            ListBookSubMenu[] lBSM = ListBookSubMenu.values();
            
            //exitSub1 for do-while loop
            boolean exitSub1 = true;
            //a simple do-while loop
            do {
                //Prompts Sub Menu list.
                Menu.bookListSubMenuView();
                //Asks user input for the sub menu items.
                int subMenuIndex = utils.getUserIntBetween("Please select one of the options below.", 1, lBSM.length) - 1;
                //simple switch to rule statement for sub menu.
                switch (lBSM[subMenuIndex]) {
                    //list books ordered by author name
                    case ORDERBYAUTHOR ->
                        lBSM[subMenuIndex].prompt();
                    //list books oredered by author name
                    case ORDERBYTITLE ->
                        lBSM[subMenuIndex].prompt();
                    //redirecting back to main menu.
                    case EXIT -> {
                        //sets exitSub1 false to finish do-while loop
                        exitSub1 = false;
                        //prompts a goodbye msg.
                        lBSM[subMenuIndex].prompt();
                    }
                    //default rule should not be run. Warns the user by prompting below msg.
                    default ->
                        System.out.println("Please restart you program. If you see this message again contact the developer.");
                }
            } while (exitSub1);
        }

    },
    /**
     * Searches for a student if registered in the system or not.
     */
    SEARCHSTUDENT {
        @Override
        public void printRequest() {
            
        }
    },
    /**
     * Fetches student entire list.
     */
    STUDENTLIST {
        @Override
        public void printRequest() {
            StudentList[] sS = StudentList.values();
            boolean exit = true;
            
            do{
                  //Prompts Sub Menu list.
                Menu.studentListSubMenuView();
                //Asks user input for the sub menu items.
                int subMenuIndex = utils.getUserIntBetween("Please select one of the options below.", 1, sS.length) - 1;
                switch(sS[subMenuIndex]) {
                    case SEARCHNAME:
                        sS[subMenuIndex].prompt();
                        break;
                    case SEARCHID:
                        sS[subMenuIndex].prompt();
                        break;
                    case EXIT:
                        exit = false;
                        sS[subMenuIndex].prompt();
                        break;
                    default:
                        System.out.println("Please restart you program. If you see this message again contact the developer.");
                    
                }
            }while(exit);
        }

    },
    /**
     * Provides an option to borrow a book to a registered student.
     */
    BORROWBOOK {
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    },
    /**
     * Provides an option to add a book back to library that returned by a
     * student.
     */
    RETURNBOOK {
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    },
    /**
     * Fetches entire student-borrow list.
     */
    STUDENTBORROWLIST {
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    },
    /**
     * Finishes program.
     */
    EXIT {
        @Override
        public void printRequest() {
            System.out.println("Goodbye. Have a nice day.");
        }

    };
    
    //New mainMenuController object.
    private static MainMenuController mMC = new MainMenuController();
    //New Utils object.
    private static Utils utils = new Utils();

    //Prints relative request applied for all enum items.
    public abstract void printRequest();

}
