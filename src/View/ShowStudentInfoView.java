/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Entities.Student;
import Utils.Constant;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class ShowStudentInfoView {

    /**
     * Shows students information properly.
     *
     * @param studentList a list of student object.
     */
    public void showStudentInfo(List<Student> studentList) {
        for (Student s : studentList) {
            System.out.println(Constant.Seprator.informationSep);
            System.out.println("Student ID: " + s.getId());
            System.out.println("Student name: " + s.getFirstName() + " " + s.getLastName());
            System.out.println("Student Address: " + s.getAddress() + "\n");
           
        }

    }

    /**
     * Shows student information.
     * @param student a student object.
     */
    public void showStudentInfo(Student student) {
        System.out.println(Constant.Seprator.informationSep);
        System.out.println("Followed information for the student bellow:");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student Address: " + student.getAddress() + "\n");
        

    }
}
