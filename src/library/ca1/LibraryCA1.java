/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library.ca1;

import Model.BinarySearch;
import Model.BookBrain.BookFactory;
import Model.Entities.Book;

/**
 *
 * @author aybatukerkukluoglu
 */
public class LibraryCA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         BookFactory test = new BookFactory();
        int i = 0;
        for(Book t: test.sortedBookList()) {
            i++;
            System.out.println(i + " " + t.toString());
        }
        
        BinarySearch test2 = new BinarySearch();
        
        System.out.println(test2.binarySearch(test.sortedBookList(), "Zorana Klais", 0, test.sortedBookList().size() - 1));
    }
    
}
