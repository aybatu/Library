/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class WriterBuffer {

    /**
     * Creates new file or finds existing file to write provided info.
     *
     * @param fileName a file name to create or search to write into.
     * @param toWrite a string list to provide text to write into file.
     */
    public void writeToFile(String fileName, List<String> toWrite) {
        //Simple try catch statement.
        try {
            //BufferedWriter FileWriter object, gets file to write. 
            //if there is already existing file writes into it in a new line via "true" param.
            BufferedWriter nBR = new BufferedWriter(new FileWriter(fileName, true));
            //A simple for loop gets elements in string array "toWrite" and store in "t"
            for (String t : toWrite) {
                //writes "t" stored string value to file.
                nBR.write(t);
                //after sucessfully written each text add space.
                nBR.write(" ");
            }
            //creates a new line after all provided info is written into file
            nBR.newLine();
            //close and saves the written info.
            nBR.close();
        } catch (Exception e) {
            //Informs user if there is an error to write.
            System.out.println("There is a problem to write file.");
        }
    }
}
