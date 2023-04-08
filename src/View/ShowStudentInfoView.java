/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Entities.Student;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class ShowStudentInfoView {
    public void showStudentInfo(List<Student> studentList) {
        for (Student s : studentList) {
           
            
            System.out.println("Student ID: " + s.getId());
            System.out.println("Student name: " + s.getFirstName() + " " + s.getLastName());
            System.out.println("Student Address: " + s.getAddress() +"\n");
        }

    }
    
    public void showStudentInfo(Student student) {

        System.out.println("Followed information for the student bellow:\n");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student Address: " + student.getAddress()+"\n");

    }
}
