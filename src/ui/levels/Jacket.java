package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class Jacket implements LevelHandler {
    private final String LEVEL_TEXT = "You need to find the jacket. It has to be somewhere in the room - otherwise you're screwed.\n" +
            "That cell phone is currently your only way of communicating with the outer world.\n\n" +
            "It's good that you've find that flashlight, otherwise it would be really hard to look for anything in here.\n\n";
    private final String LEVEL_CHOICES = "[1] Look for the jacket on the sofa\n[2] Look for the jacket on the floor\n[3] Look for the jacket on the coat hanger\n";

    @Override
    public void printLevelText() {
        HelperMethods.printTextByChar(LEVEL_TEXT,30);
    }

    @Override
    public void printLevelChoices() {
        HelperMethods.printTextByChar(LEVEL_CHOICES,30);
    }

    @Override
    public void handleChoices() {
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
