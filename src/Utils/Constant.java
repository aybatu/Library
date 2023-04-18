/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author aybatukerkukluoglu
 */
public class Constant {

    /**
     * Student related constants.
     */
    public static class Student {

        //Student list text file name
        public final static String studentListFile = "studentList.txt";
    }

    /**
     * Book related constants.
     */
    public static class Book {

        //Book list text file name.
        public final static String bookListFile = "bookList.txt";
    }

    /**
     * Book search related variables.
     */
    public static class BookSearch {

        //Defines book search by author or book title.
        public static boolean byAuthor = true;
    }

    /**
     * Student search related variables.
     */
    public static class StudentSearch {

        //Defines student search by name or ID.
        public static boolean byStudentName = true;
    }
    
    public static class Seprator {
        public static String informationSep = "***********---------***********\n";
    }

}
