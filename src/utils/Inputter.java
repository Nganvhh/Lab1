/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author MY LAPTTOP
 */
public class Inputter {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(){
        return nomalize(sc.nextLine());
    }
    
    public static String nomalize(String str) {
        str = str.trim();
        String tokens[] = str.split("\\s+");
        return String.join(" ", tokens);
    }

    public static String getNonBlankStr(String welcome, String msg) {
        String result;
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            result = nomalize(result);
            if(result.isEmpty())
                System.err.println(msg);
            else
                return result;
        } while (true);
    }

    public static String getString(String welcome, String msg) {
        boolean check = true;
        String result;
        do {
            System.out.print(welcome);
            result = nomalize(sc.nextLine());
            if (result.isEmpty()) {
                System.err.println(msg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static String getString(String welcome) {
        System.out.print(welcome);
        String result = nomalize(sc.nextLine());
        return result;
    }

    public static String getStringreg(String welcome, String pattern, String msg, String msgreg) {
        String result;
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            result = nomalize(result);
            if (result.isEmpty()) {
                System.err.println(msg);
            } else if (!result.matches(pattern)) {
                System.err.println(msgreg);
            } else {
                return result;
            }
        } while (true);
    }
    
    public static String getBlankStringreg(String welcome, String pattern, String msgreg) {
        boolean check = true;
        String result;
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                check = false;
            } else if (!result.matches(pattern)) {
                System.err.println(msgreg);
            } else {
                check = false;
            }
        } while (check);
        return nomalize(result);
    }

    public static int getAnInteger(String welcome, String errorMsg) {
        int number;
        while (true) {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(nomalize(sc.nextLine()));
                return number;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String welcome, String errorMsg, String errorMsgException, int lowerBound, int upperBound) {
        int number, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine().trim());
                if (number < lowerBound || number > upperBound) {
                    System.err.println(errorMsg);
                } else{
                    return number;
                }
                
            } catch (Exception e) {
                System.err.println(errorMsgException);
            }
        }
    }
    
    public static int getAnInteger(String welcome, String errorMsgException, int lowerBound, int upperBound) {
        int number, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine().trim());
                if (number < lowerBound || number > upperBound) {
                    System.err.println("Number must be between " + lowerBound + " to " + upperBound);
                } else{
                    return number;
                }
                
            } catch (Exception e) {
                System.err.println(errorMsgException);
            }
        }
    }

    public static int getAnInteger(String welcome, String msg, int min) {
        boolean check = true;
        int number = 0;
        do {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine().trim());
                if (number < min) {
                    System.err.println("Number must be large than " + min);
                } else {
                    check = false;
                }

            } catch (Exception e) {
                System.err.println(msg);
            }
        } while (check || number < min);
        return number;
    }
    

    public static float getFloat(String welcome, int min) {
        boolean check = true;
        float number = 0;
        do {
            try {
                System.out.print(welcome);
                number = Float.parseFloat(sc.nextLine());
                if (number < min) {
                    System.err.println("Number must be large than " + min);
                } else {
                    check = false;
                }

            } catch (Exception e) {
                System.err.println("Input number!!!");
            }
        } while (check || number < min);
        return number;
    }

    public static boolean inputYN(String msg) {
        String choice;
        while (true) {
            System.out.print(msg);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Must be Y or N");
                continue;
            }
        }
    }

    public static boolean isBlank(String str) {
        return str.isEmpty();
    }
    
    public static boolean isBlank(int num) {
        return isBlank(String.valueOf(num));
    }

}
