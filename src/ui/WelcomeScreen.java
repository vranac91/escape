package ui;

import helpers.Print;
import ui.levels.Door;

import java.util.Scanner;

public class WelcomeScreen {
    private final String WELCOME_HEADER = "Welcome to Mystery Escape v1.0!\n\n" +
            "In this textual adventure, you have to find your way out of a locked room.\n" +
            "You will do this by deciding which actions you're going to do.\n" +
            "Simply press the key surrounded with [] next to your chosen action at the end of the text...\n" +
            "...and the course of the game will change based on your choices!\n\n" +
            "Will you be able to escape the mysterious room?\n\n" +
            "Good luck!\n";
    private final String WELCOME_START = "Press [1] to start the game: ";

    public void start() {
        printWelcomeText();
        while (true) {
            Scanner scan = new Scanner(System.in);
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.print(WELCOME_START);
            }
            int input = scan.nextInt();
            if (input == 1) {
                Door door = new Door();
                door.start();
                break;
            } else {
                System.out.print(WELCOME_START);
            }
        }
    }

    private void printWelcomeText() {
        Print.printDivider();
        System.out.println(WELCOME_HEADER);
        System.out.println(WELCOME_START);
    }
}
