package bll.component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bll.dto.Hotel;
import gui.PrintFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY LAPTTOP
 */
public class SearchHotelList {

    public static void searchByHotelID(List<Hotel> list) {
        String id = DataValidation.inputHotelID("\nEnter ID to be search: ");
        for (Hotel h : list) {
            if (h.getId().equalsIgnoreCase(id.toUpperCase())) {
                PrintFormat.printAHotelFormat(h);
                return;
            }
        }
        System.err.println("No hotel was found");
    }

    public static void searchByHotelAddress(List<Hotel> list) {
        List<Hotel> tmp = new ArrayList();
        System.out.println("");
        String address = DataValidation.inputHotelAddress();
        for (Hotel h : list) {
            if (h.getAddress().toLowerCase().contains(address.toLowerCase())) {
                tmp.add(h);
            }
        }
        if (tmp.isEmpty()) {
            System.out.println("No hotel was found");
            return;
        } else {
            tmp.sort((h1, h2) -> h2.getRoomAvailable() - h1.getRoomAvailable());
            PrintFormat.printFormat(tmp);
        }

    }

}
