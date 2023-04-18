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
    //List students by their name in an order.
    LISTBYNAME {
        @Override
        public void prompt() {
            //byStudent name is set true.
            Constant.StudentSearch.byStudentName = true;
            List<Student> sL = sF.sortedStudentList();
            sSIV.showStudentInfo(sL);

        }
    },
    //List students by their id in an order.
    LISTBYID {
        @Override
        public void prompt() {
            //byStudentName is set false, list will be shown by id.
            Constant.StudentSearch.byStudentName = false;
            List<Student> sL = sF.sortedStudentList();
            sSIV.showStudentInfo(sL);
        }
    },
    //End of the sub menu.
    EXIT {
        @Override
        public void prompt() {
            System.out.println("Redirecting back to Main Menu.");
        }
    };

    //new student factory object created.
    private static StudentFactory sF = new StudentFactory();
    //new showStudentInfoView object created.
    private static ShowStudentInfoView sSIV = new ShowStudentInfoView();
    //prompt method for enum items.
    public abstract void prompt();

}
