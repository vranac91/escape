package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class Whiskey implements LevelHandler {
    private final String LEVEL_TEXT = "You drink a glass and you feel very sick. Seems like you have a hangover.\n\n" +
            "You start to have flashbacks of the previous night. You remember going out with your friends.\n" +
            "One of your friends, Frank, recently became a father, so you went out to celebrate.\n" +
            "You were drinking a lot. Really, a LOT. You remember that you've met a girl and danced with her.\n\n" +
            "But...somehow, your memory tells you that the girl had...red eyes.\n\n" +
            "You can't remember anything else. Maybe this is her house? Or your friends are having a prank?\n\n" +
            "Your cell phone might have more information. It should be in your jacket.\n\n";
    private final String LEVEL_CHOICES = "[1] Try to find the jacket\n";

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
