package ui;

import helpers.HelperMethods;
import helpers.LevelHandler;
import ui.levels.Door;

import java.util.Scanner;

public class WelcomeScreen implements LevelHandler {
    private final String WELCOME_HEADER = "Welcome to Mystery Escape v1.0!\n\n" +
            "In this textual adventure, you have to find your way out of a locked room.\n" +
            "You will do this by deciding which actions you're going to do.\n" +
            "Simply press the key surrounded with [] next to your chosen action at the end of the text...\n" +
            "...and the course of the game will change based on your choices!\n\n" +
            "Will you be able to escape the mysterious room?\n\n" +
            "Good luck!\n";
    private final String WELCOME_START = "Press [1] to start the game: ";

    @Override
    public void printLevelText() {
        System.out.println(WELCOME_HEADER);
    }

    @Override
    public void printLevelChoices() {
        System.out.println(WELCOME_START);
    }

    @Override
    public void handleChoices() {
        while (true) {
            int input = HelperMethods.validateIntInput();
            if (input == 1) {
                Door door = new Door();
                door.start();
                break;
            } else {
                System.out.print(LevelHandler.falseInputMessage);
            }
        }
    }

    public void start() {
        HelperMethods.printDivider();
        printLevelText();
        printLevelChoices();
        handleChoices();
    }
}
