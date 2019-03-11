package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

import java.util.Scanner;

public class Mirror implements LevelHandler {
    private final String LEVEL_TEXT = "Your head is cracked. There is nothing you can do, actually. Better go and take a look at the window.\n";
    private final String LEVEL_CHOICES = "[1] Go to the window\n";

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
