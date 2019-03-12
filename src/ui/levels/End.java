package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class End implements LevelHandler {
    private final String LEVEL_TEXT = "You take out the two keys from your pocket and pick up the small box from the table.\n" +
            "You place one key on the left side and the second one on the right side of the box, twisting them at the same time.\n" +
            "After a loud click, the box opens and reveals another key.\n\n" +
            "You quickly rush to the door, insert the key, twist it and...\n\n" +
            "...you hear a silent *click*, and the door is opened!\n" +
            "Overwhelmed with joy, you storm out of the room in a dark corridor.\n" +
            "You tap on the walls trying to find the light switch. There is none. You turn on the flashlight and point it at the corridor. All the walls are painted red.\n\n" +
            "Suddenly, a loud, otherworldly shriek shook the house.\n\n" +
            "To be continued...\n\n" +
            "Thank you for playing!\n";

    @Override
    public void printLevelText() {
        HelperMethods.printTextByChar(LEVEL_TEXT,30);
    }

    @Override
    public void printLevelChoices() {
        // not needed
    }

    @Override
    public void handleChoices() {
        // not needed
    }

    @Override
    public void start() {
        HelperMethods.printDivider();
        printLevelText();
        HelperMethods.printDivider();
        System.exit(0);
    }
}
