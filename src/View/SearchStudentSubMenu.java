/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Menu.SearchBookMenuController;
import Controller.Menu.SearchStudentSubMenuController;
import Utils.Constant;


/**
 *
 * @author aybatukerkukluoglu
 */
public enum SearchStudentSubMenu {
    SEARCHNAME {
        @Override
        public void prompt() {
            Constant.StudentSearch.byStudentName = true;
            sSSMC.requestStudentName("Please enter student full name you would like to search.");
            
            
        }
    },
    SEARCHID {
        @Override
        public void prompt() {
            Constant.StudentSearch.byStudentName = false;
            sSSMC.requestStudentID("Please enter student ID you would like to search.");
        }
    },
    EXIT {
        @Override
        public void prompt() {
            System.out.println("You are redirecting to Main Menu.");
        }
    };
    
    private static SearchStudentSubMenuController sSSMC = new SearchStudentSubMenuController();
    public abstract void prompt();
}
