/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.component;

import bll.dto.Hotel;
import java.util.List;
import java.util.Scanner;
import utils.Inputter;

/**
 *
 * @author MY LAPTTOP
 */
public class DataValidation extends Inputter {

    private static Scanner sc = new Scanner(System.in);

    public static Hotel searchID(List<Hotel> list, String id) {
        for (Hotel h : list) {
            if (h.getId().equalsIgnoreCase(id)) {
                return h;
            }
        }
        return null;
    }

    public static Hotel searchAddress(List<Hotel> list, String address) {
        for (Hotel h : list) {
            if (h.getAddress().equalsIgnoreCase(address)) {
                return h;
            }
        }
        return null;
    }

    public static String inputHotelID(List<Hotel> listOld) {
        String id;
        do {
            id = Inputter.getStringreg("Enter ID: ", "[H|h]\\d{2}+$", "ID is not null", "ID format is wrong");
            Hotel h = searchID(listOld, id);
            if (h != null) {
                System.out.println("ID Dupplicated");
            } else {
                break;
            }
        } while (true);
        return id.toUpperCase();
    }

    public static String inputHotelID(String msg) {
        return Inputter.getStringreg(msg, "[H|h]\\d{2}+$", "ID is not null", "ID format is wrong");
    }

    public static String inputHotelName() {
        return Inputter.getNonBlankStr("Enter Name: ", "Name is not null");
    }

    public static int inputHotelRoomAvailable() {
        return Inputter.getAnInteger("Enter Hotel Room Available: ", "Number format is wrong", -1, Integer.MAX_VALUE);
    }

    public static String inputHotelAddress(List<Hotel> list) {
        String address;
        do {
            address = Inputter.getNonBlankStr("Enter Hotel Address: ", "Address is not null");
            if (searchAddress(list, address) != null) {
                System.out.println("Address already exists");
            } else {
                return address;
            }
        } while (true);
    }

    public static String inputHotelAddress() {
        return Inputter.getNonBlankStr("Enter Hotel Address: ", "Address is not null");
    }

    public static String inputHotelPhone() {
        return Inputter.getStringreg("Enter Hotel Phone (0XXXXXXXXX): ", "^(0[35789])([0-9]{8})$", "Phone is not null", "Phone number format is wrong");
    }

    public static int inputHotelRating() {
        return Inputter.getAnInteger("Enter Hotel Rating (0-6): ", "Choose a Rating from 0 to 6", "Rating format is wrong", 0, 6);
    }


    public static int updateRoomAvailable(Hotel h, String welcome, int lowerBound, int upperBound) {
        int tmp, num;
        String room;
        boolean check = true;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        do {
            System.out.print(welcome);
            room = DataValidation.nomalize(sc.nextLine());
            if (room.isEmpty()) {
                return h.getRoomAvailable();
            }
            if (room.matches("[0-9]+")) {
                try {
                    num = Integer.parseInt(room);
                    if (num < lowerBound || num > upperBound) {
                        System.out.println("Number must be between " + lowerBound + " to " + upperBound);
                    } else {
                        return num;
                    }
                } catch (Exception e) {
                    System.out.println("Number must be between " + lowerBound + " to " + upperBound);
                }
            } else {
                System.err.println("Room format is wrong");
            }
        } while (true);
    }

    public static int updateRating(Hotel h, String welcome, int lowerBound, int upperBound) {
        int tmp, num;
        String rating;
        boolean check = true;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        do {
            System.out.print(welcome);
            rating = DataValidation.nomalize(sc.nextLine());
            if (rating.isEmpty()) {
                return h.getRating();
            }
            if (rating.matches("[0-9]+")) {
                try {
                    num = Integer.parseInt(rating);
                    if (num < lowerBound || num > upperBound) {
                        System.out.println("Number must be between " + lowerBound + " to " + upperBound);
                    } else {
                        return num;
                    }
                } catch (Exception e) {
                    System.out.println("Number must be between " + lowerBound + " to " + upperBound);
                }
            } else {
                System.err.println("Rating format is wrong");
            }
        } while (true);
    }
}
