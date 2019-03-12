package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class PhoneConnect implements LevelHandler {
    private final String LEVEL_TEXT = "You plug the cord in the wall socket and pick up the phone. It's dead. There is no signal.\n" +
            "You start to become desperate. Is this the end of you? Will the Red Eyes kill you? Will anyone look for you?\n\n" +
            "Suddenly, you remember that you should have a cell phone in your jacket. You just need to find it. It should be here somewhere...\n\n";
    private final String LEVEL_CHOICES = "[1] Look for the jacket\n";

    @Override
    public void printLevelText() {
        HelperMethods.printTextByChar(LEVEL_TEXT,30);
    }

    @Override
    public void printLevelChoices() {
        HelperMethods.printTextByChar(LEVEL_CHOICES,20);
    }

    @Override
    public void handleChoices() {
        while (true) {
            int input = HelperMethods.validateIntInput();
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
