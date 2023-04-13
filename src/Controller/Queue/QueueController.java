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

    private static MyOwnQueue myQ;
    private static int bTIndex = 1;
    private static int sIDIndex = 0;
    private String studentID;

    public void writeToFile(String fileName, List<String> data) {
        WriterBuffer wB = new WriterBuffer();
        wB.writeToFile(fileName, data);
    }

    private List<String> readFromFile(String fileName) {
        FileReaderScanner fRC = new FileReaderScanner(fileName);
        return fRC.readLineby();
    }

    public void prepareQueue() {
        List<String> qList = readFromFile("queueList.txt");
        myQ = new MyOwnQueue(qList.size());
        for (String q : qList) {
            myQ.Enqueue(q);
        }
    }

    public static MyOwnQueue getMyQ() {
        return myQ;
    }

    public String getStudentID() {
        return studentID;
    }

    public boolean queueSearch(String data) {
        Utils u = new Utils();
        if (!myQ.isEmpty()) {
            do {
                String[] id = u.strSplitter(myQ.First(), " ");
                String bookTitle = "";
                for (int i = bTIndex; i < id.length; i++) {
                    if (id.length - 1 == i) {
                        bookTitle += id[i].trim();
                    } else {
                        bookTitle += id[i].trim() + " ";
                    }
                }

                if (bookTitle.equalsIgnoreCase(data)) {
                    studentID = id[sIDIndex];
                    u.removeLine("queueList.txt", studentID + " " + bookTitle);
                    return true;
                } else {
                    myQ.Dequeue();
                }

            } while (!myQ.isEmpty());
        }

        return false;
    }

    public void addQueue(String studentID, String bookName) {
        QueueController restartQ = new QueueController();
        List<String> data = new ArrayList<>();

        data.add(studentID);
        data.add(bookName);

        writeToFile("queueList.txt", data);
        restartQ.prepareQueue();
        System.out.println("Student ID: " + studentID + " successfully added into a waiting list. You will be informed when book returned back in library.\n");

    }

}
