/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entities;

import Utils.Constant;

/**
 *
 * @author aybatukerkukluoglu
 */
public class Book implements Comparable<Book>{
    //PROPERTIES
    private String id;
    private String title;
    private String authorFN;
    
    /**
     * Book constructor
     * @param id a string unique ID for a book
     * @param authorFN author full name of a book
     * @param title book name
     */
    public Book(String id, String authorFN, String title) {
        this.id = id;
        this.authorFN = authorFN;
        this.title = title;
    }
    /**
     * A simple getter for the book ID
     * @return a string unique ID for the book
     */
    public String getId() {
        return id;
    }
    /**
     * A simple getter the book title
     * @return a string for the book title
     */
    public String getTitle() {
        return title;
    }
    /**
     * A simple getter for the book author full name
     * @return a string for the author full name.
     */
    public String getAuthor() {
        return authorFN;
    }

    /**
     * Implemented by 'Comparable' interface
     * @param o A book object for alphabetical comparison.
     * @return an integer value as a comparison result.
     */
    @Override
    public int compareTo(Book o) {
        return toString().compareTo(o.toString().toLowerCase());
    }

    /**
     * Overrides 'toString' when object called by itself provides author full name of the book
     * @return a string for the book's author full name.
     */
    @Override
    public String toString() {
        if(Constant.BookSearch.byAuthor) {
            return authorFN.toLowerCase();
        } else {
            return title.toLowerCase();
        }
    }

    
}
