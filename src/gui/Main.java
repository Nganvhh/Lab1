/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.component.DataValidation;
import bll.component.InputMainMenu;
import bll.serviceinterface.HotelService;
import java.io.EOFException;

/**
 *
 * @author MY LAPTTOP
 */
public class Main {

    public static void main(String[] args) throws EOFException {
        HotelService h = new HotelService();
        int choice;
        boolean checkLoad = false;
        boolean checkSave = false;
        do {
            choice = InputMainMenu.mainMenu();
            if (choice == 2 || choice == 4 || choice == 5) {
                checkSave = true;
            }
            switch (choice) {
                case 1:
                    if(checkLoad) {
                        System.out.println("Load successfully");
                        break;
                    }
                    checkLoad = true;
                    h.loadFromFile();
                    break;
                case 2:
                    if(checkLoad == false){
                        System.out.println("Look like your list is empty - Make sure to load data from the file first.");
                        System.out.println("If you do not load data from the file first, YOUR DATA MAY HAVE CLEARED if you added a new hotel.");
                        if(DataValidation.inputYN("Do you want to continue add new hotel? (Y/N)")==false)
                            break;
                        else {
                            h.addHotel();
                            checkLoad = true;
                            break;
                        }
                    }
                    h.addHotel();
                    break;
                case 3:
                    if(checkLoad == false) {
                        System.out.println("List is empty");
                        break;
                    }
                    h.checkExitsHotel();
                    break;
                case 4:
                    if(checkLoad == false) {
                        System.out.println("List is empty");
                        break;
                    }
                    h.updateHotelInfomation();
                    break;
                case 5:
                    if(checkLoad == false) {
                        System.out.println("List is empty");
                        break;
                    }
                    h.deleteHotel();
                    break;
                case 6:
                    if(checkLoad == false) {
                        System.out.println("List is empty");
                        break;
                    }
                    h.searchHotel();
                    break;
                case 7:
                    if(checkLoad == false) {
                        System.out.println("List is empty");
                        break;
                    }
                    h.displayHotel();
                    break;
                case 8:
                    h.saveToFile();
                    checkSave = false;
                    break;
                default:
                    if (checkSave == true) {
                        if(DataValidation.inputYN("Do you want to save the changes? (Y/N): "))
                            h.saveToFile();
                    }
                    System.out.println("Quit");
                    break;
            }
        } while (choice > 0 && choice < 9);
    }
}
