/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.BookBrain;

import Model.BubbleSort;
import Model.Sorting;
import Model.Entities.Book;
import Utils.Constant;
import Utils.FileReaderScanner;
import Utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author aybatukerkukluoglu
 */
public class BookFactory {
    //PROPERTIES
    
    //regxPattern to divide strings read from the txt file.
    private static final String regxPattern = " ";
    //Indexes for created new array with splitted regxPattern
    //Book ID index
    private static final int bookIDIndx = 0;
    //Author last name index
    private static final int aLIndx = 1;
    //author first name index.
    private static final int aFIndx = 2;
    //book title start index.
    private static final int bTIndx = 3;
    
    /**
     * The method creates a sorted Book ArrayList by Author name.
     * @return array list of Book.
     */
    public List<Book> sortedBookList() {
        //a new Book array list stored in bookList.
        List<Book> bookList = new ArrayList<>();
        //a new book bookArr assigned to list of books created by a txt file.
        Book[] bookArr = retrieveBookList(Constant.Book.bookListFile);
        //A new BubbleSort object.
        Sorting bSort = new BubbleSort();
        
        //bookArr sorted bu bubbleSorting method.
        bSort.bubbleSorting(bookArr);
        //All object of bookArr added to bookList array list.
        bookList.addAll(Arrays.asList(bookArr));
        //Returns the new array list.
        return bookList;
    }
    
    /**
     * It's a private method creates a book list by reading from a provided text file.
     * @param fileName File name to read for the information.
     * @return a Book object array
     */
    private Book[] retrieveBookList(String fileName) {
        //New file reader scanner object address stored in "fR"
        FileReaderScanner fR = new FileReaderScanner(fileName);
        //new utils object.
        Utils utils = new Utils();
        //New String List 'bookListInfo' assigned the read lines from provided txt file.
        List<String> bookListInfo = fR.readLineby();
        //New Book object array with the size of bookListInfo list
        Book[] bookArr = new Book[bookListInfo.size()];

        //A simple for loop
        for (int i = 0; i < bookListInfo.size(); i++) {
            //String array bookListInfo splited txt arrays
            String[] bookInfo = utils.strSplitter(bookListInfo.get(i), regxPattern);
            
            //BookID assigned to BookID retrevied from the txt file.
            String bookID = bookInfo[bookIDIndx];
            //Autjor full name stored to aFN retrevied from the txt file.
            String aFN = bookInfo[aLIndx] + " " + bookInfo[aFIndx];
            //bT assigned to Book Title retrevied from the txt file.
            String bT = "";
            //A simple for loop checks for the rest of the indexes of bookInfo array.
            for(int j = bTIndx; j < bookInfo.length; j++) {
                //If the index of the array is last one addes it to 'bT' without a space.
                if(j == bookInfo.length - 1) {
                    bT += bookInfo[j].trim();
                }else {//else addes the string in the index to 'bT' with a space.
                    bT += bookInfo[j].trim() + " ";
                }
            }
           
            //Creates a new book with retrieved data.
            Book newBook = new Book(bookID, aFN, bT);
            
            //addes new book into bookArr
            bookArr[i] = newBook;
            
        } 
        //returns bookArr.
        return bookArr;
    }
    
    
}
