/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Menu.BorrowBookMenuController;
import Controller.Queue.QueueController;
import Utils.Utils;
import View.MainMenu;
import View.MenuView;

/**
 *
 * @author aybatukerkukluoglu
 */
public class StartProgram {

    /**
     * Empty constructor.
     */
    public StartProgram() {
    }

    /**
     * Initiates Library program and provides menu rotation.
     */
    public void initiateLibrary() {
        // new QeueueController object.
        QueueController startQ = new QueueController();
        //Student Queue is loaded on memory
        startQ.prepareQueue();
        //BorrowBookMenuController object.
        BorrowBookMenuController bBMC = new BorrowBookMenuController();
        //borrowList is written on memory
        bBMC.updateBorrowList();
        //New Utils object.
        Utils utils = new Utils();

        //MainMenu enum values stored in mM.
        MainMenu[] mM = MainMenu.values();
        //exit set true for do-while loop.
        boolean exit = true;

        //A simple do-while loop.
        do {
            //Prompts main menu view.
            MenuView.mainMenuListView();
            //Asks user input to choose for any menu item.
            int userInput = utils.getUserIntBetween("Please select item you would like to query.", 1, mM.length) - 1;
            //Main menu switch-case statement.
            switch (mM[userInput]) {
                //Menu items.
                case SEARCHBOOK ->
                    mM[userInput].printRequest();
                case LISTBOOKS ->
                    mM[userInput].printRequest();
                case SEARCHSTUDENT ->
                    mM[userInput].printRequest();
                case STUDENTLIST ->
                    mM[userInput].printRequest();
                case BORROWBOOK ->
                    mM[userInput].printRequest();
                case RETURNBOOK ->
                    mM[userInput].printRequest();
                case STUDENTBORROWLIST ->
                    mM[userInput].printRequest();
                case EXIT -> {
                    mM[userInput].printRequest();
                    exit = false;
                }
                //if there is no error default statement should not work.
                default ->
                    System.out.println("Please restart you program. If you see this message again contact the developer.");

            }
            //search for a specific book by its name.
            //Prompts book list either ordered by author or title

        } while (exit);
    }
}
