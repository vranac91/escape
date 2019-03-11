package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

import java.util.Scanner;

public class NoteReading implements LevelHandler {
    private final String LEVEL_TEXT = "You take the paper from the floor and look at it. It contains only four words, written with a black pen:\n\n" +
            "BEWARE OF THE DOG\n\n" +
            "\"What? What dog? Okay, this is seriously becoming ridiculous. I better go and see if I can escape via window.\"\n" +
            "While you were standing above the note, a drop of blood fell on it. You realize that the blood on the floor was yours.\n\n" +
            "Better look around for a mirror to see how smashed your head really is.\n";
    private final String LEVEL_CHOICES = "[1] Go to the window\n[2] Find the mirror\n";

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
                Window window = new Window();
                window.start();
                break;
            }  else if (input == 2) {
                Mirror mirror = new Mirror();
                mirror.start();
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
