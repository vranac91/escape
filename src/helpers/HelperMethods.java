package helpers;

import java.util.Scanner;

import static helpers.LevelHandler.falseInputMessage;

public class HelperMethods {

    /*
    Adds a typewriter-like effect when printing out text
     */

    public static void printTextByChar(String string, int speedInMillis) {
        for (char c : string.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(speedInMillis);
            } catch (Exception e) {
                System.out.println("Error in printing string by char!");
            }
        }
    }

    /*
    Prints a section separator of predefined lengnth
     */

    public static void printDivider() {
        System.out.println();
        for (int i = 1; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println();
    }

    /*
    Checks if the input passed by the user is integer
    - if it is not, prints warning message and waits for next user input
    - if it is, returns that int
     */

    public static int validateIntInput() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print(falseInputMessage);
        }
        return scan.nextInt();
    }
}
