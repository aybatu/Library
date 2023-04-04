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
public enum MainMenu {
    SEARCHBOOK {
        @Override
        public void printRequest() {
            
            MainMenuController mMC = new MainMenuController();
            Constant.BookSearch.byAuthor = false;
            mMC.requestBookName();
            
        } 
    },
    
    LISTBOOKS {
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    },
    
    SEARCHSTUDENT {
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    },
    
    STUDENTLIST {
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    },
    
    BORROWBOOK {
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    },
    
    RETURNBOOK{
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    },
    
    STUDENTBORROWLIST {
        @Override
        public void printRequest() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    };
    
    public abstract void printRequest();
}
