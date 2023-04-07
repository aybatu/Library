/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Queue;

import Model.Entities.MyOwnQueue;
import Utils.FileReaderScanner;
import Utils.WriterBuffer;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class QueueController {

    private static MyOwnQueue myQ;

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

}
