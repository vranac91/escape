package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

import java.util.Scanner;

public class PhoneConnect implements LevelHandler {
    private final String LEVEL_TEXT = "You plug the cord in the wall socket and pick up the phone. It's dead. There is no signal.\n" +
            "You start to become desperate. Is this the end of you? Will the Red Eyes kill you? Will anyone look for you?\n" +
            "Suddenly, you remember that you should have a cell phone in your jacket. You just need to find it. It should be here somewhere...\n";
    private final String LEVEL_CHOICES = "[1] Look for the jacket\n";

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
                Jacket jacket = new Jacket();
                jacket.start();
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
