/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Book;

import Utils.FileReaderScanner;
import Utils.Utils;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class BookTitleReader {

    private static final String regxPattern = " ";
    private static final int bookTitleIndex = 1;

    /**
     * Empty constructor.
     */
    public BookTitleReader() {
    }

    public HashSet<String> bookBorrowTitleSet(String fileName) {
        //New file reader scanner object address stored in "fR"
        FileReaderScanner fR = new FileReaderScanner(fileName);
        //new utils object.
        Utils utils = new Utils();
        //New String List 'bookListInfo' assigned the read lines from provided txt file.
        List<String> bookListInfo = fR.readLineby();
        //New Book object array with the size of bookListInfo list
        HashSet<String> titleSet = new HashSet<>();

        //A simple for loop
        for (int i = 0; i < bookListInfo.size(); i++) {
            //String array bookListInfo splited txt arrays
            String[] bookInfo = utils.strSplitter(bookListInfo.get(i), regxPattern);

            String bT = "";
            //A simple for loop checks for the rest of the indexes of bookInfo array.
            for (int j = bookTitleIndex; j < bookInfo.length; j++) {
                //If the index of the array is last one addes it to 'bT' without a space.
                if (j == bookInfo.length - 1) {
                    bT += bookInfo[j].trim();
                } else {//else addes the string in the index to 'bT' with a space.
                    bT += bookInfo[j].trim() + " ";
                }
            }
            //book title added into titleSet.
            titleSet.add(bT);
        }
        //returns bookArr.
        return titleSet;

    }
}
