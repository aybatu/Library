/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author aybatukerkukluoglu
 */
public class Utils {

    /**
     * Splits provided text with a provided regxPattern.
     *
     * @param textToSplit String text to split
     * @param regxPattern regxPattern to identify after which condition to
     * split.
     * @return Split text returns in a string array
     */
    public String[] strSplitter(String textToSplit, String regxPattern) {
        //Creates an array and stored the split text into the array
        String[] newText = textToSplit.split(regxPattern);
        //returns aray
        return newText;

    }
}
