/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.MainMenuController;
import Model.Entities.Student;
import Model.StudentBrain.StudentFactory;
import Utils.Constant;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public enum StudentList {
    SEARCHNAME {
        @Override
        public void prompt() {
            Constant.StudentSearch.byStudentName = true;
            List<Student> sL = sF.sortedStudentList();
            mMC.showStudentInfo(sL);
            
        }
    },
    SEARCHID {
        @Override
        public void prompt() {
            Constant.StudentSearch.byStudentName = false;
            List<Student> sL = sF.sortedStudentList();
            mMC.showStudentInfo(sL);
        }
    },
    EXIT {
        @Override
        public void prompt() {
            System.out.println("Redirecting back to Main Menu.");
        }
    };

    private static StudentFactory sF = new StudentFactory();
    private static MainMenuController mMC = new MainMenuController();
    public abstract void prompt();

}
