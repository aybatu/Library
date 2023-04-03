/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author aybatukerkukluoglu
 */
public class FileReaderScanner {
    //Properties
    private String fileName;
    
    //Constructor
    public FileReaderScanner(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Scanner file reader object is used to read a file.
     * @return is a String List created by read lines from the file. 
     */
    public List<String> readLineby() {
        //A string array list to store texts read from a file.
        List<String> fileInfo = new ArrayList<>();
        //Simple try catch statement
        try {
            //Scanner file reader object
            Scanner newReader = new Scanner(new FileReader(fileName));
            //A simple file loop
            while(newReader.hasNext()){//if the file to read has next line returns true condition guard
                //trims the text before adding into fileInfo string list.
                fileInfo.add(newReader.nextLine().trim());
            }
        } catch(Exception e){
            //If there is an error informs users.
            System.out.println("There is no file found with the specified name: " + fileName);
        }
        //returns fileInfo String list
        return fileInfo;
    }
}
