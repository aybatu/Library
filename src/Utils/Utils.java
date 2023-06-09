/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

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

    /**
     * Called method asks user for a input and returns it back as a string.
     *
     * @param prompt is a string parameter. Declares what is the requested
     * input.
     * @return returns users input as a string.
     */
    public String getString(String prompt) {
        //Reads user input with bufferedReader object.
        BufferedReader myKB = new BufferedReader(new InputStreamReader(System.in));
        //If there is no error user input will be stored in userInput variable. It has empty string default value for return statement.
        String userInput = "";
        //isValid variable is used for do-while loop. Default value is false. If there is no error and program
        //able to get user input into try catch statement a "true" value will be stored in the variable and loop will stop.
        boolean isValid = false;

        do {
            //prints prompt parameter to inform user.
            System.out.println(prompt);
            try {
                //Gets user input as a string value and stores it in userInput variable.
                //and just in case trims back-front spaces.
                userInput = myKB.readLine().trim();
                //Stores a true value in isValid variable in order to stop loop.
                isValid = true;
            } catch (Exception e) {
                System.out.println("There is something wrong please try again to enter your input.");
            }
        } while (!isValid);//while-guard condition.

        //Returns userInput if there is no error. 
        return userInput;
    }

    /**
     * Removes a line from a provided text file.
     *
     * @param fileName file name to go through.
     * @param data data to delete.
     * @return A Boolean value for the status.
     */
    public boolean removeLine(String fileName, String data) {
        //Creates a file with provided file name.
        File inputFile = new File(fileName);
        //Creates a temp text file.
        File tempFile = new File("temp.txt");
        //status initially set false.
        boolean status = false;
        //A simple try-catch statement.
        try {
            //A new BufferedReader object created.
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            //A new BufferedReader object is created.
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            //stores data parameter to lineToRemove variable.
            String lineToRemove = data;
            //Null string variable for the current line.
            String currentLine;

            //a while loop checks file has line and stores the line info to currentLine variable.
            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                //if trimmedLine is equals to lineToRemove
                if (trimmedLine.toLowerCase().equals(lineToRemove.toLowerCase())) {
                    //status is set true.
                    status = true;
                    //Continue to loop.
                    continue;
                }
                //Writes the current line to temp file and adds a line separator..
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            //saves temps file
            writer.close();
            //saves data file.
            reader.close();
        } catch (Exception e) {
            System.out.println("File could not be found.");
        }
        // renames the temp file with the input file name.
        boolean successful = tempFile.renameTo(inputFile);

        return status;
    }

    /**
     * Prompt user to enter an integer between two numbers - if invalid keep
     * asking
     *
     * @param prompt informs user for the requested input
     * @param min minimum value of the requested number
     * @param max maximum value of the requested number
     * @return a number between desired min-max parameters.
     */
    public int getUserIntBetween(String prompt, int min, int max) {
        // Scanner initialization - myKB object to read user input
        Scanner myKB = new Scanner(System.in);
        //Valid user input is stored into userInput variable
        int userInput = 0;
        //boolean type 'valid' variable assigned false - it is used for do-while loop
        boolean valid = false;

        //A simple while loop
        while (!valid) {
            //informs user through prompt parameter.
            System.out.println(prompt);

            //if-else statement checks if the number is a valid integer or not.
            if (myKB.hasNextInt()) {
                userInput = myKB.nextInt();//if provided guard condition requirments assigns userInput to user int input
                if (userInput >= min && userInput <= max) {//Checks if the entered input provide requirtments of min and max parameters
                    valid = true; // stops the loop once it gets user input successfully
                } else {
                    //If the input is not between the max and min values informs user for a valid input.
                    System.out.println("Nice try! But the number you entered is must be between " + min + " and " + max + "!");
                }
            } else {
                //Informs user for the valid input
                System.out.println("Invalid input please enter a whole number and between " + min + " - " + max + ". Minumum and maximum values are included for the valid input.");
                myKB.next(); //Gets new line to check new user input.
            }
        }

        //returns valid userInput
        return userInput;
    }
}
