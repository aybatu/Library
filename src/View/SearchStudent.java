/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.MainMenuController;
import Utils.Constant;


/**
 *
 * @author aybatukerkukluoglu
 */
public enum SearchStudent {
    SEARCHNAME {
        @Override
        public void prompt() {
            Constant.StudentSearch.byStudentName = true;
            mMC.requestStudentName();
            
            
        }
    },
    SEARCHID {
        @Override
        public void prompt() {
            Constant.StudentSearch.byStudentName = false;
            mMC.requestStudentID();
        }
    },
    EXIT {
        @Override
        public void prompt() {
            System.out.println("You are redirecting to Main Menu.");
        }
    };
    
    private static MainMenuController mMC = new MainMenuController();
    public abstract void prompt();
}
