/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Entities.Student;
import Controller.Student.StudentFactory;
import Utils.Constant;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public enum StudentListSubMenu {
    LISTBYNAME {
        @Override
        public void prompt() {
            Constant.StudentSearch.byStudentName = true;
            List<Student> sL = sF.sortedStudentList();
            sSIV.showStudentInfo(sL);
            
        }
    },
    LISTBYID {
        @Override
        public void prompt() {
            Constant.StudentSearch.byStudentName = false;
            List<Student> sL = sF.sortedStudentList();
            sSIV.showStudentInfo(sL);
        }
    },
    EXIT {
        @Override
        public void prompt() {
            System.out.println("Redirecting back to Main Menu.");
        }
    };

    private static StudentFactory sF = new StudentFactory();
    private static ShowStudentInfoView sSIV = new ShowStudentInfoView();
    public abstract void prompt();

}
