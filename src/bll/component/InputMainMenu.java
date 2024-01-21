package bll.component;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import gui.Menu;

/**
 *
 * @author MY LAPTTOP
 */
public class InputMainMenu {
    public static int mainMenu(){
        Menu menuFunction = new Menu("HOTEL MANAGEMENT");
        menuFunction.addNewOption("Load data from file to program");
        menuFunction.addNewOption("Adding new Hotel");
        menuFunction.addNewOption("Checking exits Hotel");
        menuFunction.addNewOption("Updating Hotel information");
        menuFunction.addNewOption("Deleting Hotel");
        menuFunction.addNewOption("Searching Hotel");
        menuFunction.addNewOption("Displaying a hotel list(descending by name)");
        menuFunction.addNewOption("Save data to file");
        menuFunction.addNewOption("Others Quit");
        
        menuFunction.printMenu();
        return menuFunction.getChoice();
    }
    
}
