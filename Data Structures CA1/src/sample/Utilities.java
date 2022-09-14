package sample;

public class Utilities {

    private static String numbersOnly = "[0-9]+";


    public static boolean max30Chars(String string) {
        return (string.length() <= 30) ? true : false;
    }

    public static boolean max10Chars(String string) {
        return (string.length() <= 10) ? true : false;
    }

    public static boolean validEmail(String email) {
        if (email != null) {
            return (email.contains("@") && email.contains("."));
        }
        return false;
    }

    public static boolean onlyContainsNumbers(String text) {
        if (text != null) {
            return (text.matches(numbersOnly));
        }
        return false;
    }

    public static boolean validPPS(String PPS) {
        if (PPS.length() == 9) {
            return (PPS.substring(0, 7).matches("[0-9]+") && PPS.substring(7, 9).matches("[A-Za-z]+"));
        } else {
            return false;
        }
    }


    public static boolean validIntRange(int min, int max, int i) { /* we use min first, then max, then i because we want i to be in between min and max */
        if (i >= min && i <= max) {
            return true;
        } else {
            return false;
        }

    }
    public static boolean validEircode(String Eir) {
        if (Eir.length() == 6) {
            return (Eir.substring(1,2).matches("[0-9]+") && Eir.substring(0,3).matches("[A-Z]+") && Eir.substring(4,6).matches("[A-Z]+") && (Eir.substring(6).matches("[0-9]+")));
        } else {
            return false;
        }
    }

    public static boolean validIdentifier(String ID){
        if (ID.length() == 2){
            return (ID.substring(0).matches("[A-Z]+") && ID.substring(1).matches("[0-9]+"));
        } else{
            return false;
        }
    }
}
















