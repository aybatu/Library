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

    public void initiateLibrary() {
        Utils utils = new Utils();

        MainMenu[] mM = MainMenu.values();
        ListBookSubMenu[] lBSM = ListBookSubMenu.values();
        boolean exit = true;

        do {
            Menu.promptMainMenuList();
            int userInput = utils.getUserIntBetween("Please select item you would like to query.", 1, mM.length) - 1;

            switch (mM[userInput]) {
                case SEARCHBOOK:
                    mM[userInput].printRequest();
                    break;
                case LISTBOOKS:
                    boolean exitSub1 = true;
                    do {
                        Menu.promptBookListSubMenu();
                        int firstSubMenu = utils.getUserIntBetween("Please select one of the options below.", 1, lBSM.length) - 1;
                        
                        switch (lBSM[firstSubMenu]) {
                            case ORDERBYAUTHOR:
                                lBSM[firstSubMenu].prompt();
                                break;
                            case ORDERBYTITLE:
                                lBSM[firstSubMenu].prompt();
                                break;
                            case EXIT:
                                exitSub1 = false;
                                lBSM[firstSubMenu].prompt();
                                break;
                            default:
                                System.out.println("Please restart you program. If you see this message again contact the developer.");
                        }
                    } while (exitSub1);
                case SEARCHSTUDENT:
                    break;
                case STUDENTLIST:
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
