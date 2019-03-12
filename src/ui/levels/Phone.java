package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class Phone implements LevelHandler {
    private final String LEVEL_TEXT = "Slowly, you crawl on the floor, still shaking from the horrible shriek produced by that...thing.\n\n" +
            "You find the phone resting on the desk. The phone is unplugged from the wall.\n\n" +
            "There is also half a bottle of whiskey and a glass next to it. It might help you cool down and focus.\n\n";
    private final String LEVEL_CHOICES = "[1] Try to plug in the phone\n[2] Take a shot of whiskey\n";

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
                PhoneConnect connect = new PhoneConnect();
                connect.start();
                break;
            } else if (input == 2) {
                Whiskey whiskey = new Whiskey();
                whiskey.start();
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
