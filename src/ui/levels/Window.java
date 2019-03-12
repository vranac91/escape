package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class Window implements LevelHandler {
    private final String LEVEL_TEXT = "You come to the window, only realizing that you're too high to jump without dying.\n\n" +
            "Luckily, you see a man walking his dog.\nMaybe he can set you free, or at least call a police.\n\n" +
            "";
    private final String LEVEL_CHOICES = "[1] Wave and call for help\n";

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
