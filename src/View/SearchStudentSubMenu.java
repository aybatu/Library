/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Menu.SearchStudentSubMenuController;
import Utils.Constant;

/**
 *
 * @author aybatukerkukluoglu
 */
public enum SearchStudentSubMenu {
    //Search student by name.
    SEARCHNAME {
        @Override
        public void prompt() {
            //set true search is done by student name.
            Constant.StudentSearch.byStudentName = true;
            sSSMC.requestStudentName("Please enter student full name you would like to search.");

        }
    },
    //search student by id.
    SEARCHID {
        @Override
        public void prompt() {
            //set false student search is done by ID.
            Constant.StudentSearch.byStudentName = false;
            sSSMC.requestStudentID("Please enter student ID you would like to search.");
        }
    },
    //exit, finish the sub menu.
    EXIT {
        @Override
        public void prompt() {
            System.out.println("You are redirecting to Main Menu.");
        }
    };
    //new SearchStudentSubMenuController object created.
    private static SearchStudentSubMenuController sSSMC = new SearchStudentSubMenuController();

    //abstact prompt method for enum items.
    public abstract void prompt();
}
