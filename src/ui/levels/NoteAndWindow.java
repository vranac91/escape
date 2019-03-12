package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

public class NoteAndWindow implements LevelHandler {
    private final String LEVEL_TEXT = "You reach the for the knob and try to open the door, only to realize that it's locked.\n" +
            "\n\"Great. Now what?\"\n" +
            "\nThere is a light switch next to the door. You press it, but nothing happens - seems like the light bulb is toast.\n" +
            "Fortunately, there is a small flashlight placed on top of a small table next to the door. You take it, turn it on and start to look around the room.\n" +
            "\nYou look down and see a piece of paper lying on the floor. Seems like some kind of a note. Could this make some clarification?\n" +
            "\nYou look to the left and see the outside light protruding through the half-opened window. Maybe you could simply jump out?\n\n";
    private final String LEVEL_CHOICES = "[1] Take the piece of paper from the floor\n[2] Go to the window\n";

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
                NoteReading reading = new NoteReading();
                reading.start();
                break;
            } else if (input == 2) {
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
