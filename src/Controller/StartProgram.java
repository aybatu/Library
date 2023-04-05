/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Utils.Utils;
import View.ListBookSubMenu;
import View.MainMenu;
import View.Menu;

/**
 *
 * @author aybatukerkukluoglu
 */
public class StartProgram {

    /**
     * Initiates Library program and provides menu rotation.
     */
    public void initiateLibrary() {
        //New Utils object.
        Utils utils = new Utils();

        //MainMenu enum values stored in mM.
        MainMenu[] mM = MainMenu.values();
        //exit set true for do-while loop.
        boolean exit = true;

        //A simple do-while loop.
        do {
            //Prompts main menu view.
            Menu.mainMenuListView();
            //Asks user input to choose for any menu item.
            int userInput = utils.getUserIntBetween("Please select item you would like to query.", 1, mM.length) - 1;
            //Main menu switch-case statement.
            switch (mM[userInput]) {
                //search for a specific book by its name.
                case SEARCHBOOK:
                    mM[userInput].printRequest();
                    break;
                //Prompts book list either ordered by author or title
                case LISTBOOKS:
                    mM[userInput].printRequest();
                    break;
                case SEARCHSTUDENT:
                    
                    break;
                case STUDENTLIST:
                    mM[userInput].printRequest();
                    break;
                case BORROWBOOK:
                    break;
                case RETURNBOOK:
                    break;
                case STUDENTBORROWLIST:
                    break;
                case EXIT:
                    mM[userInput].printRequest();
                    exit = false;
                    break;
                default:
                    System.out.println("Please restart you program. If you see this message again contact the developer.");

            }

        } while (exit);
    }
}
