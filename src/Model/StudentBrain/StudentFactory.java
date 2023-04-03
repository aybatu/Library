/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.StudentBrain;

import Utils.Constant;
import Utils.WriterBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class StudentFactory {
    /**
     * Writes provided student information to student list file.
     * @param studentInfo A string list with student information to write on text file.
     */
    public void registerStudent(List<String> studentInfo) {
        //New WriterBuffer object.
        WriterBuffer nWB = new WriterBuffer();
        //A string array list
        List<String> studentInfoList = new ArrayList<>();
        //simple for loop goes through studentInfo parameter
        for(String i: studentInfo) {
            //each provided student information is added to "studentInfoList" string array list.
            studentInfoList.add(i);
        }
        //Writes student information to clarified text file 
        nWB.writeToFile(Constant.Student.studentListFile, studentInfoList);
    }
    
}
