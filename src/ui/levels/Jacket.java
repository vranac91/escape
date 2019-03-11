package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

import java.util.Scanner;

public class Jacket implements LevelHandler {
    private final String LEVEL_TEXT = "You need to find the jacket. It has to be somewhere in the room - otherwise you're screwed.\n\n" +
            "You try to turn on the light, but the light switch does nothing. Fortunately, there is a small flashlight under the mirror, on the cupboard.\n" +
            "You take the flashlight and begin exploring the room.\n";
    private final String LEVEL_CHOICES = "[1] Look for the jacket on the sofa\n[2] Look for the jacket on the floor\n[3] Look for the jacket on the coat hanger\n";

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
                JacketSofa sofa = new JacketSofa();
                sofa.start();
                break;
            } else if (input == 2) {
                JacketFloor floor = new JacketFloor();
                floor.start();
                break;
            } else if(input == 3) {
                JacketHanger hanger = new JacketHanger();
                hanger.start();
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
