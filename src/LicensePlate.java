import java.util.Scanner;

/**
 * Determines if a given license plate number is valid.
 * 
 * @author Erik Aultman
 * 
 */
public final class LicensePlate {

    /**
     * 
     */
    private LicensePlate() {
    }

    /**
     * Checks if all characters of a given string input are numbers and returns
     * true otherwise returns false.
     * 
     * @param string
     *            - string to check of all characters are numbers
     * @return - true if string (@string) is a number and false otherwise
     */
    private static boolean isNum(String string) {
        //checks all characters in string if they are numbers
        for (int count = 0; count < string.length(); count++) {
            //if a character is not a number return false
            if (!Character.isDigit(string.charAt(count))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all characters of a given string input are capital letters and
     * returns true otherwise returns false.
     * 
     * @param string
     *            - string to check of all characters are capital letters
     * @return - true if string (@string) is all capital letters and false
     *         otherwise
     */
    private static boolean isAlphaCap(String string) {
        boolean result = true; //boolean value to return
        /*
         * check all characters in string if they are capital letters
         */
        for (int count = 0; count < string.length(); count++) {
            //if not a capital letter return false
            if (!Character.isAlphabetic(string.charAt(count))
                    || !Character.isUpperCase(string.charAt(count))) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Check if a given license plate is valid if it follows the format
     * ABC-1234.
     * 
     * @param plate
     *            - the string to be checked
     * @return - return true if the string(@plate) is a valid license plate and
     *         false otherwise
     */
    private static boolean isPlate(String plate) {
        boolean result = false; //result to be returned
        //if plate is not 8 characters return false
        if (plate.length() == 8) {
            //if plate follows format ABC-1234 then is valid plate
            if (isAlphaCap(plate.substring(0, 3))
                    && isNum(plate.substring(4, 8)) && plate.charAt(3) == '-') {
                result = true;
            }
        }

        return result;
    }

    /**
     * Main method.
     * 
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        //input stream for user defined ranges
        Scanner in = new Scanner(System.in);
        //get license plate number from user
        System.out
                .println("Enter license plate number in the form \"ABC-1234\"");
        String plate = in.nextLine();

        if (isPlate(plate)) {
            System.out.println("This is a valid license plate!");
        } else {
            System.out.println("No, this is not a valid license plate.");
        }
        in.close();
    }

}
