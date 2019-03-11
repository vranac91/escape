package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

import java.util.Scanner;

public class JacketFloor implements LevelHandler {
    public static boolean itemObtained = false;
    public static int foundItems = 0;

    private final String LEVEL_TEXT = "You look everywhere, duck under every piece of furniture, but there is no jacket.\n" +
            "Instead, you hit the jackpot - your phone was resting under the big old table! Overfilled, with joy, you open it and unlock the screen.\n\n" +
            "The moment the screen lights up, you realize that your situation has just become even weirder.\n\n" +
            "The phone is completely blocked, and the screen shows a picture of the table in front of you, with one of the drawers circled in red.\n" +
            "Before you even start to comprehend how the hell did a picture of the table come to your phone, the phone shuts down due to the empty battery.\n\n" +
            "You quickly find the circled drawer, open it and find a small box with two keyholes, a rectangular and a circular one.\n\n" +
            "You take it outside and place it on the table.\n";

    private final String LEVEL_CHOICE_ALL_SOLVED = "[1] Try to open the small box\n";
    private final String LEVEL_CHOICE_SOFA_SOLVED = "[1] Look for the jacket on the coat hanger\n";
    private final String LEVEL_CHOICE_HANGER_SOLVED = "[1] Look for the jacket on the sofa\n";
    private final String LEVEL_CHOICE_NONE_SOLVED = "[1] Look for the jacket on the sofa\n[2] Look for the jacket on the coat hanger\n";

    @Override
    public void printLevelText() {
        System.out.println(LEVEL_TEXT);
    }

    @Override
    public void printLevelChoices() {
        if (JacketHanger.itemObtained && JacketSofa.itemObtained) {
            System.out.println(LEVEL_CHOICE_ALL_SOLVED);
            foundItems = 3;
        } else if (JacketHanger.itemObtained) {
            System.out.println(LEVEL_CHOICE_HANGER_SOLVED);
            foundItems = 2;
        } else if (JacketSofa.itemObtained) {
            System.out.println(LEVEL_CHOICE_SOFA_SOLVED);
            foundItems = 1;
        } else {
            System.out.println(LEVEL_CHOICE_NONE_SOLVED);
        }
    }

    @Override
    public void handleChoices() {
        switch (foundItems) {
            case 0: // none solved, 2 choices: sofa and hanger
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
                        JacketHanger hanger = new JacketHanger();
                        hanger.start();
                        break;
                    } else {
                        System.out.print(falseInputMessage);
                    }
                }

            case 1: // sofa solved, 1 choice: hanger
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

            case 2: // hanger solved, 1 choice: sofa
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
