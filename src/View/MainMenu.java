/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Menu.SearchBookMenuController;
import Utils.Constant;
import Utils.Utils;

/**
 * Main MenuView Options.
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
            mMC.requestBookTitle("Please enter book title you would like to search.");

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
                //Prompts Sub MenuView list.
                MenuView.bookListSubMenuView();
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
            SearchStudentSubMenu[] sS = SearchStudentSubMenu.values();
            boolean exit = true;

            do {
                //Prompts Sub MenuView list.
                MenuView.studentSearchMenuView();
                //Asks user input for the sub menu items.
                int subMenuIndex = utils.getUserIntBetween("Please select one of the options below.", 1, sS.length) - 1;

                switch (sS[subMenuIndex]) {
                    case SEARCHNAME -> {
                        sS[subMenuIndex].prompt();
                    }
                    case SEARCHID -> {
                        sS[subMenuIndex].prompt();
                    }
                    case EXIT -> {
                        exit = false;
                        sS[subMenuIndex].prompt();
                    }
                    default ->
                        System.out.println("Please restart you program. If you see this message again contact the developer.");
                }
            } while (exit);
        }
    },
    /**
     * Fetches student entire list.
     */
    STUDENTLIST {
        @Override
        public void printRequest() {
            StudentListSubMenu[] sL = StudentListSubMenu.values();
            boolean exit = true;

            do {
                //Prompts Sub MenuView list.
                MenuView.studentListSubMenuView();
                //Asks user input for the sub menu items.
                int subMenuIndex = utils.getUserIntBetween("Please select one of the options below.", 1, sL.length) - 1;
                switch (sL[subMenuIndex]) {
                    case LISTBYNAME ->
                        sL[subMenuIndex].prompt();

                    case LISTBYID ->
                        sL[subMenuIndex].prompt();

                    case EXIT -> {
                        exit = false;
                        sL[subMenuIndex].prompt();
                    }
                    default ->
                        System.out.println("Please restart you program. If you see this message again contact the developer.");

                }
            } while (exit);
        }

    },
    /**
     * Provides an option to borrow a book to a registered student.
     */
    BORROWBOOK {
        @Override
        public void printRequest() {
            Constant.StudentSearch.byStudentName = false;
            Constant.BookSearch.byAuthor = false;
           
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
    private static SearchBookMenuController mMC = new SearchBookMenuController();
    //New Utils object.
    private static Utils utils = new Utils();

    //Prints relative request applied for all enum items.
    public abstract void printRequest();

}
