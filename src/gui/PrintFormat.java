package gui;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import bll.dto.Hotel;
import java.util.List;

/**
 *
 * @author MY LAPTTOP
 */
public class PrintFormat {

    public static void printFormat(List<Hotel> list) {
        System.out.println("");
        for (int i = 0; i < 150; i++) {
            System.out.printf("-");
        }
        System.out.printf("\n| ID |%8s%4s%8s|Room Available|%40s%7s%40s|   Phone  | Rating |\n", " ", "Name", " ", " ", "Address", " ", "Phone", "Rating");
        for (int i = 0; i < 150; i++) {
            System.out.printf("-");
        }
        System.out.println("");
        for (Hotel h : list) {
            h.hotelInfor();
            for (int i = 0; i < 150; i++) {
                System.out.printf("-");
            }
            System.out.println("");
        }
    }

    public static void printAHotelFormat(Hotel h) {
        for (int i = 0; i < 150; i++) {
            System.out.printf("-");
        }
        System.out.printf("\n| ID |%8s%4s%8s|Room Available|%40s%7s%40s|   Phone  | Rating |\n", " ", "Name", " ", " ", "Address", " ", "Phone", "Rating");
        for (int i = 0; i < 150; i++) {
            System.out.printf("-");
        }
        System.out.println("");
        h.hotelInfor();
        for (int i = 0; i < 150; i++) {
            System.out.printf("-");
        }
        System.out.println("");
    }

}
