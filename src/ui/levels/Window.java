package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

import java.util.Scanner;

public class Window implements LevelHandler {
    private final String LEVEL_TEXT = "You come to the window, only realizing that you're too high to jump without dying.\n\n" +
            "Luckily, you see a man walking his dog.\nMaybe he can set you free, or at least call a police.\n";
    private final String LEVEL_CHOICES = "[1] Wave and call for help\n";

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
                ManAndDog manAndDog = new ManAndDog();
                manAndDog.start();
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
