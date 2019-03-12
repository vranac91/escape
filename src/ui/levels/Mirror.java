package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class Mirror implements LevelHandler {
    private final String LEVEL_TEXT = "You find the mirror attached to a wall opposite of the desk.\n" +
            "You point the flashlight in the mirror and scare yourself.\n\n" +
            "On the right side of your forehead, there is a big, deep cut, like someone broke a bottle on your head.\n" +
            "Half of your face is covered in blood; you are almost unable to recognize yourself.\n\n" +
            "Next to your reflection, you notice a writing in red:\n\n" +
            "RUN\n\n" +
            "A wave of panic and fear overflows you. You are unsure if this is simply someone messing with you, or your life is really in danger.\n\n" +
            "You need to find a way out - fast.\n\n";
    private final String LEVEL_CHOICES = "[1] Go to the window\n";

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
                Window window = new Window();
                window.start();
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
