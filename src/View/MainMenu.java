/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Menu.BorrowBookMenuController;
import Controller.Menu.BorrowListController;
import Controller.Menu.ReturnBookController;
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
            //New mainMenuController object.
            SearchBookMenuController mMC = new SearchBookMenuController();
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
            //SearchStudentSubMenu enum values stored in an array.
            SearchStudentSubMenu[] sS = SearchStudentSubMenu.values();
            //do-while loop condition variable 'exit'.
            boolean exit = true;

            //a simple do-while loop.
            do {
                //Prompts Sub MenuView list.
                MenuView.studentSearchMenuView();
                //Asks user input for the sub menu items.
                int subMenuIndex = utils.getUserIntBetween("Please select one of the options below.", 1, sS.length) - 1;
                //a simple switch-case statement with 'sS' enum.
                switch (sS[subMenuIndex]) {
                    //search for a name
                    case SEARCHNAME -> {
                        sS[subMenuIndex].prompt();
                    }
                    //search for an ID
                    case SEARCHID -> {
                        sS[subMenuIndex].prompt();
                    }
                    //executes sub menu.
                    case EXIT -> {
                        exit = false;
                        sS[subMenuIndex].prompt();
                    }
                    //informs user there might be a bug.
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
            //StudentListSubMenu enum values stored in an array 'sL'
            StudentListSubMenu[] sL = StudentListSubMenu.values();
            //do-while loop conditioner.
            boolean exit = true;

            //a simple do-while loop
            do {
                //Prompts Sub MenuView list.
                MenuView.studentListSubMenuView();
                //Asks user input for the sub menu items.
                int subMenuIndex = utils.getUserIntBetween("Please select one of the options below.", 1, sL.length) - 1;
                //a simple switch-case statement with array 'sL'
                switch (sL[subMenuIndex]) {
                    //Order students by name.
                    case LISTBYNAME ->
                        sL[subMenuIndex].prompt();
                    //Order student by their IF
                    case LISTBYID ->
                        sL[subMenuIndex].prompt();
                    //executes sub menu.
                    case EXIT -> {
                        exit = false;
                        sL[subMenuIndex].prompt();
                    }
                    //informs user there might be a bug.
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
            //Student Search result will be done with ID not by a name.
            Constant.StudentSearch.byStudentName = false;
            //Book search will be done by a book title not author name.
            Constant.BookSearch.byAuthor = false;
            //new BorrowBookMenuController object.
            BorrowBookMenuController bBMC = new BorrowBookMenuController();
            //new BookBorrowSubMenu object.
            BookBorrowSubMenu[] subMenu = BookBorrowSubMenu.values();
            //borrowBook method status stored in isStudentID
            boolean isStudentID = bBMC.borrowBook();
            //askForBook variable initially set true, if student id is valid next step will be applied for a book name.
            boolean askForBook = true;
            if (!isStudentID) {
                //do-while loop
                do {
                    //BorrowBookSubMenu view to inform user menu selection.
                    BorrowBookSubMenuView.borrowBookSubMenuView();
                    //User input for the menu selection
                    int i = utils.getUserIntBetween("", 1, subMenu.length) - 1;
                    //switch-case for the sub menu.
                    //if student id fetch is failed asks for next time if user wants to try again or not.
                    switch (subMenu[i]) {
                        case YES ->
                            //when selected yes tries again to find student id.
                            isStudentID = bBMC.borrowBook();
                        case NO -> {
                            //stops loop and set next step false, redirecting back to main menu.
                            askForBook = false;
                            isStudentID = true;
                            System.out.println("You are redirecting to the main menu.");
                        }
                    }

                } while (!isStudentID);
            }

            //borrowBook set true initially for next step after getting book title.
            boolean borrowBook = true;
            if (askForBook) {
                //checks for the book name if its valid or not
                boolean isBook = bBMC.borrowBook();
                //if its not valid ask user if would like try again.
                if (!isBook) {
                    //do - while loop
                    do {
                        //Menu view for the sub menu.
                        BorrowBookSubMenuView.borrowBookSubMenuView();
                        //user input.
                        int i = utils.getUserIntBetween("", 1, subMenu.length) - 1;
                        //If user selected yes, borrow boook method will be called again.
                        switch (subMenu[i]) {
                            case YES ->
                                isBook = bBMC.borrowBook();
                            case NO -> {
                                //if user choice is no next step set false, and loop set false.
                                borrowBook = false;
                                isBook = true;
                                System.out.println("You are redirecting to the main menu.");
                            }
                        }

                    } while (!isBook);
                }
            }
            //if borrow book is true
            if (borrowBook) {
                //last step is applied by calling borrowBook method last time.
                bBMC.borrowBook();
            }
        }
    },
    /**
     * Provides an option to add a book back to library that returned by a
     * student.
     */
    RETURNBOOK {
        @Override
        public void printRequest() {
            //New ReturnBookController.
            ReturnBookController rBC = new ReturnBookController();
            //returnBook method called.
            rBC.returnBook();

        }

    },
    /**
     * Fetches entire student-borrow list.
     */
    STUDENTBORROWLIST {
        @Override
        public void printRequest() {
            //New BorrowListController object created.
            BorrowListController bLC = new BorrowListController();
            //showBorrowList called for the file borrowList.txt.
            bLC.showBorrowList("borrowList.txt");
        }

    },
    /**
     * End of the program.
     */
    EXIT {
        @Override
        public void printRequest() {
            //end of the application.
            System.out.println("Goodbye. Have a nice day.");
        }

    };

    //New Utils object.
    private static Utils utils = new Utils();

    //Prints relative request applied for all enum items.
    public abstract void printRequest();

}
