package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

import java.util.Scanner;

public class NoteAndWindow implements LevelHandler {
    private final String LEVEL_TEXT = "You reach the for the knob and try to open the door, only to realize that they are locked.\n" +
            "\n\"Great. Now what?\"\n" +
            "\nYou look down and see a piece of paper lying on the floor. Could this make some clarification?\n" +
            "\nYou look to the left and see the outside light protruding through the half-opened window. Maybe you could simply jump out?\n";
    private final String LEVEL_CHOICES = "[1] Take the piece of paper from the floor\n[2] Go to the window\n";

    @Override
    public void printLevelText() {
        System.out.println(LEVEL_TEXT);
    }

    @Override
    public void printLevelChoices() {
        System.out.println(LEVEL_CHOICES);
    }

    @Override
    public void handleChoices() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println(falseInputMessage);
            }
            int input = scan.nextInt();
            if (input == 1) {
                NoteReading reading = new NoteReading();
                reading.start();
                break;
            } else if (input == 2) {
                Window window = new Window();
                window.start();
                break;
            } else {
                System.out.print(falseInputMessage);
            }
        }
    }

    @Override
    public void start() {
        HelperMethods.printDivider();
        printLevelText();
        printLevelChoices();
        handleChoices();
    }
}
