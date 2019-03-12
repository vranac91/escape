package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

public class Peek implements LevelHandler {
    public final String LEVEL_TEXT = "You duck and stay down, your heart pumping so fast that you can't hear anything. You feel like you're gonna faint.\n" +
            "You decide to peek and look for the scary man and his companion.\n" +
            "You slowly go for the window...only to realize that they are gone.\n\n" +
            "They could have gone somewhere else...or they are about to enter the house and look for you.\n\n" +
            "You can't take it anymore. You need to find a way to contact the outer world.\n\n";
    public final String LEVEL_CHOICES = "[1] Look for the telephone\n";

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
                Phone phone = new Phone();
                phone.start();
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
