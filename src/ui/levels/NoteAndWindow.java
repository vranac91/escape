package ui.levels;

import helpers.LevelHandler;
import helpers.Print;

public class NoteAndWindow implements LevelHandler {
    private final String LEVEL_TEXT = "test hello";
    private final String LEVEL_CHOICES = "";

    @Override
    public void printLevelText() {
        System.out.println(LEVEL_TEXT);
    }

    @Override
    public void printLevelChoices() {
        System.out.println(LEVEL_CHOICES);
    }

    @Override
    public void handleChoices() {

    }

    @Override
    public void start() {
        Print.printDivider();
        printLevelText();
        printLevelChoices();
        handleChoices();
    }
}
