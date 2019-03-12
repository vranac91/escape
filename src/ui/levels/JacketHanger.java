package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class JacketHanger implements LevelHandler {
    private final String LEVEL_TEXT = "Your jacket is not on the hanger, but someone else's is.\n" +
            "You decide to search through the jacket and find a small, circular key.\n\n" +
            "You quickly run to the door hoping to open them, only to realize that the key is not right.\n\n" +
            "You put the key in your pocket.\n\n";

    private final String LEVEL_CHOICE_ALL_SOLVED = "[1] Try to open the small box\n";
    private final String LEVEL_CHOICE_SOFA_SOLVED = "[1] Look for the jacket on the floor\n";
    private final String LEVEL_CHOICE_FLOOR_SOLVED = "[1] Look for the jacket on the sofa\n";
    private final String LEVEL_CHOICE_NONE_SOLVED = "[1] Look for the jacket on the sofa\n[2] Look for the jacket on the floor\n";

    public static boolean itemObtained = false;
    public static int foundItems = 0;

    @Override
    public void printLevelText() {
        HelperMethods.printTextByChar(LEVEL_TEXT,30);
    }

    @Override
    public void printLevelChoices() {
        if (JacketFloor.itemObtained && JacketSofa.itemObtained) {
            HelperMethods.printTextByChar(LEVEL_CHOICE_ALL_SOLVED, 20);
            foundItems = 3;
        } else if (JacketFloor.itemObtained) {
            HelperMethods.printTextByChar(LEVEL_CHOICE_FLOOR_SOLVED, 20);
            foundItems = 2;
        } else if (JacketSofa.itemObtained) {
            HelperMethods.printTextByChar(LEVEL_CHOICE_SOFA_SOLVED,20);
            foundItems = 1;
        } else {
            HelperMethods.printTextByChar(LEVEL_CHOICE_NONE_SOLVED, 20);
        }
    }

    @Override
    public void handleChoices() {
        switch (foundItems) {
            case 0: // none solved, 2 choices: sofa and floor
                while (true) {
                    int input = HelperMethods.validateIntInput();
                    if (input == 1) {
                        JacketSofa sofa = new JacketSofa();
                        sofa.start();
                        break;
                    } else if (input == 2) {
                        JacketFloor floor = new JacketFloor();
                        floor.start();
                        break;
                    } else {
                        System.out.print(falseInputMessage);
                    }
                }

            case 1: // sofa solved, 1 choice: floor
                while (true) {
                    int input = HelperMethods.validateIntInput();
                    if (input == 1) {
                        JacketFloor floor = new JacketFloor();
                        floor.start();
                        break;
                    } else {
                        System.out.print(falseInputMessage);
                    }
                }

            case 2: // floor solved, 1 choice: sofa
                while (true) {
                    int input = HelperMethods.validateIntInput();
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
                    int input = HelperMethods.validateIntInput();
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
