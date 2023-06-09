/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Utils.Constant;

/**
 *
 * @author aybatukerkukluoglu
 */
public class MenuView {

    /**
     * Main MenuView View.
     */
    public static void mainMenuListView() {
      
        System.out.println("\n1. Search for a book.");
        System.out.println("2. Fetch book list in the library ordered by 'Author Name' or 'Book Title'.");
        System.out.println("3. Search for a student.");
        System.out.println("4. Fetch registered student list ordered by 'ID' or 'Full Name'.");
        System.out.println("5. Register a book borrow.");
        System.out.println("6. Register a book return.");
        System.out.println("7. Show student-borrow list.");
        System.out.println("8. Exit.\n");
    }

    /**
     * Book List option sub menu view.
     */
    public static void bookListSubMenuView() {
        
        System.out.println("\n1. List all books ordered by Author Name.");
        System.out.println("2. List all books ordered by Book Title.");
        System.out.println("3. Exit.\n");

    }

    /**
     * Student list sub menu view.
     */
    public static void studentListSubMenuView() {
        System.out.println("\n1. List all students ordered by name.");
        System.out.println("2. List all students ordered ID.");
        System.out.println("3. Exit.\n");
    }

    /**
     * Student search sub menu view.
     */
    public static void studentSearchMenuView() {
        
        System.out.println("\n1. Search by a student name.");
        System.out.println("2. Search by a studnet ID.");
        System.out.println("3. Exit.\n");
    }

    /**
     * Book borrow approve menu view.
     */
    public static void borrowBookApprov() {
        System.out.println(Constant.Seprator.informationSep);
        System.out.println("\nWould you like to borrow the book specified student?");
        System.out.println("1. Yes.");
        System.out.println("2. No.\n");
        System.out.println(Constant.Seprator.informationSep);
    }
}
