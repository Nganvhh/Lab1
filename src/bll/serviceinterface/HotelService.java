package bll.serviceinterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bll.component.DataValidation;
import bll.component.SearchHotelList;
import bll.dto.Hotel;
import dal.FileManagement;
import gui.Menu;
import gui.PrintFormat;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import utils.Inputter;

/**
 *
 * @author MY LAPTTOP
 */
public class HotelService implements IHotelService {

    private List<Hotel> listOld;
    private final String filename = "hotel.dat";
    private FileManagement fm;

    public HotelService() throws EOFException {
        listOld = new ArrayList();
        fm = new FileManagement();
    }

    public void loadFromFile() {
        fm.loadDataFromFile(listOld, filename);
        System.out.println("Load successfully");
    }

    @Override
    public void addHotel() {
        String choice;
        do {
            String id, name, address, phone;
            int roomAvailable, rating;
            System.out.println("\nInput new Hotel information:");
            id = DataValidation.inputHotelID(listOld);
            name = DataValidation.inputHotelName();
            roomAvailable = DataValidation.inputHotelRoomAvailable();
            address = DataValidation.inputHotelAddress(listOld);
            phone = DataValidation.inputHotelPhone();
            rating = DataValidation.inputHotelRating();
            Hotel h = new Hotel(id, name, roomAvailable, address, phone, rating);
            listOld.add(h);
            System.out.println("\nThe new Hotel has been added successfully!");
        } while (Inputter.inputYN("Do you want to continue?(Y/N): "));
    }

    @Override
    public void checkExitsHotel() {
//        loadFromFile();
        do {
            if (listOld.isEmpty()) {
                System.out.println("List is empty!");
                return;
            }
            String id = DataValidation.inputHotelID("\nEnter ID to be check: ");
            Hotel h = DataValidation.searchID(listOld, id);
            if (h != null) {
                System.out.println("Exist Hotel");
            } else {
                System.err.println("No Hotel Found!");
            }
        } while (DataValidation.inputYN("Do you want to continue checking?(Y/N): "));

    }

    @Override
    public void updateHotelInfomation() {
        String searchId = DataValidation.inputHotelID("\nEnter ID to be update: ");
        Hotel h = DataValidation.searchID(listOld, searchId);
        if (h == null) {
            System.err.println("Hotel does not exist");
            return;
        }
        String name, address, phone;
        int roomAvailable, rating;

        name = DataValidation.getString("Enter Name: ");
        if (DataValidation.isBlank(name)) {
            name = h.getName();
        }
        roomAvailable = DataValidation.updateRoomAvailable(h, "Enter Room Available: ", 0, Integer.MAX_VALUE);
//        if (DataValidation.isBlank(roomAvailable)) {
//            roomAvailable = h.getRoomAvailable();
//        }
        do {
            address = DataValidation.getString("Enter Hotel Address: ");
            if(DataValidation.searchAddress(listOld, address) != null)
                System.out.println("Address already exists");
            else
                break;
        } while (true);
        
        if (DataValidation.isBlank(address)) {
            address = h.getAddress();
        }
        phone = DataValidation.getBlankStringreg("Enter Hotel Phone (0XXXXXXXXX): ", "^(0[35789])([0-9]{8})$", "Phone number format is wrong");
        if (DataValidation.isBlank(phone)) {
            phone = h.getPhone();
        }
        rating = DataValidation.updateRating(h, "Enter Rating: ", 0, 6);
//        if (DataValidation.isBlank(rating)) {
//            rating = h.getRating();
//        }
        h.setName(name);
        h.setRoomAvailable(roomAvailable);
        h.setAddress(address);
        h.setPhone(phone);
        h.setRating(rating);
        PrintFormat.printAHotelFormat(h);
    }

    @Override
    public void deleteHotel() {
        String searchId = DataValidation.inputHotelID("\nEnter ID to be detele: ");
        Hotel h = DataValidation.searchID(listOld, searchId);
        if (h == null) {
            System.out.println("No hotel was found");
            return;
        }
        PrintFormat.printAHotelFormat(h);
        if (DataValidation.inputYN("Do you really want to delete this hotel? (Y/N): ") == false) {
            System.out.println("\nDelete failed");
            return;
        }
        listOld.remove(h);
        System.out.println("\nDeleted successfully");
    }

    @Override
    public void searchHotel() {
        Menu smenu = new Menu("Search Hotel");
        smenu.addNewOption("Search by Hotel ID");
        smenu.addNewOption("Search by Hotel Address");
        smenu.printMenu();
        int choice = smenu.getChoice();
        switch (choice) {
            case 1:
                SearchHotelList.searchByHotelID(listOld);
                break;
            case 2:
                SearchHotelList.searchByHotelAddress(listOld);
                break;
        }
    }

    @Override
    public void displayHotel() {
        if (listOld.isEmpty()) {
            System.out.println("No Hotel Found");
            return;
        }
        listOld.sort((h1, h2) -> h2.getName().compareToIgnoreCase(h1.getName()));
        PrintFormat.printFormat(listOld);
        System.out.println("Total: " + listOld.size() + " hotel(s)");
    }

    @Override
    public void saveToFile() {
        fm.saveDataToFile(listOld, filename, "\nSaved Successfully");
    }
    
    public void quit(){
        
    }
}
