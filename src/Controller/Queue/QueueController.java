/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Queue;

import Model.Entities.MyOwnQueue;
import Utils.FileReaderScanner;
import Utils.Utils;
import Utils.WriterBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class QueueController {
    //PROPERTIES.
    private static String queueListFile = "queueList.txt";
    //Null MyOwnQueue pointer.
    private static MyOwnQueue myQ;
    //bookTitle index.
    private static final int bTIndex = 1;
    //student id index.
    private static final int sIDIndex = 0;
    //null studentID
    private String studentID;

    /**
     * Empty constructor.
     */
    public QueueController() {
    }

    /**
     * Writes provided data onto provided text file.
     *
     * @param fileName text file name to write.
     * @param data list of data to write.
     */
    public void writeToFile(String fileName, List<String> data) {
        WriterBuffer wB = new WriterBuffer();
        wB.writeToFile(fileName, data);
    }

    /**
     * Reads a text file and provided a list of content.
     *
     * @param fileName String file name to read.
     * @return text file content in a list recorded line by line.
     */
    private List<String> readFromFile(String fileName) {
        FileReaderScanner fRC = new FileReaderScanner(fileName);
        return fRC.readLineby();
    }

    /**
     * Reads queue list text file and updates queue regarding to data.
     */
    public void prepareQueue() {
        //Fetches queueList.txt data into a arraylist.
        List<String> qList = readFromFile(queueListFile);
        //Creates a new queue with the count of the lines in queueList text file.
        myQ = new MyOwnQueue(qList.size());
        //A simple for loop
        for (String q : qList) {
            //enqueue all information to new myownqueue object.
            myQ.enqueue(q);
        }
    }

    /**
     * Fetches a Book queue.
     *
     * @return MyOwnQeueu object.
     */
    public static MyOwnQueue getMyQ() {
        return myQ;
    }

    /**
     * Provides student id
     *
     * @return string.
     */
    public String getStudentID() {
        return studentID;
    }

   /**
    * Searches through provided queue list file for the data, and provides a student id for entity property, updates the data file.
    * @param data String data to search queue list data file.
    * @return Boolean if data is found true.
    */
    public boolean queueSearch(String data) {
        //A new Utils object.
        Utils u = new Utils();
        //if myQ is not null
        if (!myQ.isEmpty()) {
            //a simple do-while loop.
            do {
                //fethes 'myQ' queue first element and splits for the spaces stores in a String array.
                String[] id = u.strSplitter(myQ.first(), " ");
                //Book title stored in the variable.
                String bookTitle = "";
                /*
                ID array has to data for each element. First one 
                is a ID of the student, second is a book title.
                A simple for loop starts from book title index
                and adds all String elements to book title within
                id array each element, and creates entire book title.
                */
                for (int i = bTIndex; i < id.length; i++) {
                    if (id.length - 1 == i) {
                        bookTitle += id[i].trim();
                    } else {
                        bookTitle += id[i].trim() + " ";
                    }
                }
                //if created book title matches with the data parameter
                if (bookTitle.equalsIgnoreCase(data)) {
                    //Stores student id for the index of book title into studentID variable.
                    studentID = id[sIDIndex];
                    //removes entire line of the book title.
                    u.removeLine(queueListFile, studentID + " " + bookTitle);
                    //return true
                    return true;
                } else {
                    //else does deqeueu to check for next element in the queue.
                    myQ.dequeue();
                }
                
            } while (!myQ.isEmpty());// does the loop til queue is empty.
        }

        return false;
    }
    /**
     * Adds student and book to a queue.
     * @param studentID String student id.
     * @param bookName String Book title.
     */
    public void addQueue(String studentID, String bookName) {
        //A new QueueController object address stored in restartQ pointer.
        QueueController restartQ = new QueueController();
        //A new array list object address stored in data pointer.
        List<String> data = new ArrayList<>();
        
        //Provided parameters added in to data array list.
        data.add(studentID);
        data.add(bookName);
        //data array list passed to writeToFile method, and the data is written on to
        //provided queue list data file.
        writeToFile(queueListFile, data);
        //queue is restarted with prepareQueue method.
        restartQ.prepareQueue();
        //User is informed with a message.
        System.out.println("Student ID: " + studentID + " successfully added into a waiting list. You will be informed when book returned back in library.\n");

    }

}
