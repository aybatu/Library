/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Student;

import Controller.SortAlgorithms;
import Controller.SortAlgorithms;
import Controller.Sorting;
import Controller.Sorting;
import Model.Entities.Student;
import Utils.Constant;
import Utils.FileReaderScanner;
import Utils.Utils;
import Utils.WriterBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class StudentFactory {
    //PROPERTIES
    //regxPattern to divide strings read from the txt file.
    private static final String regxPattern = " ";
    //Indexes for created new array with splitted regxPattern
    //Book ID index
    private static final int studentIDIndex = 0;
    //Author last name index
    private static final int sLIndex = 1;
    //author first name index.
    private static final int sFIndex = 2;
    //book title start index.
    private static final int sAddIndex = 3;

    /**
     * The method creates a sorted Student ArrayList by student name.
     *
     * @return array list of Book.
     */
    public List<Student> sortedStudentList() {
        //a new Student array list stored in studentList.
        List<Student> studentList = new ArrayList<>();
        //a new student studentArr assigned to list of books created by a txt file.
        Student[] studentArr = retrieveStudentList(Constant.Student.studentListFile);
        //A new SortAlgorithms object.
        Sorting iSort = new SortAlgorithms();

        //studentArr sorted bu bubbleSorting method.
        iSort.insertionSorting(studentArr);
        //All object of studentArr added to studentList array list.
        studentList.addAll(Arrays.asList(studentArr));
        //Returns the new array list.
        return studentList;
    }

    /**
     * It's a private method creates a student list by reading from a provided text
     * file.
     *
     * @param fileName File name to read for the information.
     * @return a Book object array
     */
    private Student[] retrieveStudentList(String fileName) {
        //New file reader scanner object address stored in "fR"
        FileReaderScanner fR = new FileReaderScanner(fileName);
        //new utils object.
        Utils utils = new Utils();
        //New String List 'studentListInfo' assigned the read lines from provided txt file.
        List<String> studentListInfo = fR.readLineby();
        //New Student object array with the size of studentListInfo list
        Student[] studentArr = new Student[studentListInfo.size()];

        //A simple for loop
        for (int i = 0; i < studentListInfo.size(); i++) {
            //String array studentListInfo splited txt arrays
            String[] studentInfo = utils.strSplitter(studentListInfo.get(i), regxPattern);

            //studentID assigned to Student ID retrieved from the txt file.
            String studentID = studentInfo[studentIDIndex];
            String sID = studentID;
            //Student first name stored to sFN retrieved from the txt file.
            String sFN = studentInfo[sFIndex];
             //Student last name stored to sLN retrieved from the txt file.
            String sLN = studentInfo[sLIndex];
            //sAdd assigned to student address retrieved from the txt file.
            String sAdd = "";
            //A simple for loop checks for the rest of the indexes of studnetInfo array.
            for (int j = sAddIndex; j < studentInfo.length; j++) {
                //If the index of the array is last one addes it to 'sAdd' without a space.
                if (j == studentInfo.length - 1) {
                    sAdd += studentInfo[j].trim();
                } else {//else adds the string in the index to 'sAdd' with a space.
                    sAdd += studentInfo[j].trim() + " ";
                }
            }

            //Creates a new student with retrieved data.
            Student newStudent = new Student(sID, sFN, sLN, sAdd);

            //addes new student into studentArr
            studentArr[i] = newStudent;

        }
        //returns studentArr.
        return studentArr;
    }

    /**
     * Writes provided student information to student list file.
     *
     * @param studentInfo A string list with student information to write on
     * text file.
     */
    public void registerStudent(List<String> studentInfo) {
        //New WriterBuffer object.
        WriterBuffer nWB = new WriterBuffer();
        //A string array list
        List<String> studentInfoList = new ArrayList<>();
        //simple for loop goes through studentInfo parameter
        for (String i : studentInfo) {
            //each provided student information is added to "studentInfoList" string array list.
            studentInfoList.add(i);
        }
        //Writes student information to clarified text file 
        nWB.writeToFile(Constant.Student.studentListFile, studentInfoList);
    }

}
