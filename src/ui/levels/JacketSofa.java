package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

import java.util.Scanner;

public class JacketSofa implements LevelHandler {
    public static boolean itemObtained = false;
    private int foundItems = 0;

    private final String LEVEL_TEXT = "You come to the sofa and look for the jacket, but it's not there.\n" +
            "However, a glimpse of your eye catches something shiny that is partially hidden by the pillow.\n\n" +
            "You remove the pillow and find the rectangular key.\n\n" +
            "Quickly, you rush to the door and try to unlock them, only to find out that the key doesn't fin the keyhole.\n" +
            "You keep the key and put it in your pocket.\n";

    private final String LEVEL_CHOICE_ALL_SOLVED = "[1] Try to open the small box\n";
    private final String LEVEL_CHOICE_FLOOR_SOLVED = "[1] Look for the jacket on the coat hanger\n";
    private final String LEVEL_CHOICE_HANGER_SOLVED = "[1] Look for the jacket on the floor\n";
    private final String LEVEL_CHOICE_NONE_SOLVED = "[1] Look for the jacket on the floor\n[2] Look for the jacket on the coat hanger\n";

    @Override
    public void printLevelText() {
        System.out.println(LEVEL_TEXT);
    }

    @Override
    public void printLevelChoices() {
        if (JacketHanger.itemObtained && JacketFloor.itemObtained) {
            System.out.println(LEVEL_CHOICE_ALL_SOLVED);
            foundItems = 3;
        } else if (JacketHanger.itemObtained) {
            System.out.println(LEVEL_CHOICE_HANGER_SOLVED);
            foundItems = 2;
        } else if (JacketFloor.itemObtained) {
            System.out.println(LEVEL_CHOICE_FLOOR_SOLVED);
            foundItems = 1;
        } else {
            System.out.println(LEVEL_CHOICE_NONE_SOLVED);
        }
    }

    @Override
    public void handleChoices() {
        switch (foundItems) {
            case 0: // none solved, 2 choices: floor and hanger
                while (true) {
                    Scanner scan = new Scanner(System.in);
                    while (!scan.hasNextInt()) {
                        scan.next();
                        System.out.println(falseInputMessage);
                    }
                    int input = scan.nextInt();
                    if (input == 1) {
                        JacketFloor floor = new JacketFloor();
                        floor.start();
                        break;
                    } else if (input == 2) {
                        JacketHanger hanger = new JacketHanger();
                        hanger.start();
                        break;
                    } else {
                        System.out.print(falseInputMessage);
                    }
                }

            case 1: // floor solved, 1 choice: hanger
                while (true) {
                    Scanner scan = new Scanner(System.in);
                    while (!scan.hasNextInt()) {
                        scan.next();
                        System.out.println(falseInputMessage);
                    }
                    int input = scan.nextInt();
                    if (input == 1) {
                        JacketHanger hanger = new JacketHanger();
                        hanger.start();
                        break;
                    } else {
                        System.out.print(falseInputMessage);
                    }
                }

            case 2: // hanger solved, 1 choice: floor
                while (true) {
                    Scanner scan = new Scanner(System.in);
                    while (!scan.hasNextInt()) {
                        scan.next();
                        System.out.println(falseInputMessage);
                    }
                    int input = scan.nextInt();
                    if (input == 1) {
                        JacketFloor floor = new JacketFloor();
                        floor.start();
                        break;
                    } else {
                        System.out.print(falseInputMessage);
                    }
                }

            default: // all solved
                while (true) {
                    Scanner scan = new Scanner(System.in);
                    while (!scan.hasNextInt()) {
                        scan.next();
                        System.out.println(falseInputMessage);
                    }
                    int input = scan.nextInt();
                    if (input == 1) {
                        End end = new End();
                        end.start();
                        break;
                    } else {
                        System.out.print(falseInputMessage);
                    }
                }
        }
    }

    @Override
    public void start() {
        HelperMethods.printDivider();
        itemObtained = true;
        printLevelText();
        printLevelChoices();
        handleChoices();
    }
}
