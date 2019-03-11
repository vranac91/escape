package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

import java.util.Scanner;

public class Phone implements LevelHandler {
    private final String LEVEL_TEXT = "Slowly, you crawl on the phone, still shaking from the horrible shriek produced by that...thing.\n\n" +
            "You find the phone resting on the desk. The phone is unplugged from the wall.\n\n" +
            "There is also half a bottle of whiskey and a glass next to it. It might help you cool down and focus.\n";
    private final String LEVEL_CHOICES = "[1] Try to plug in the phone\n[2] Take a shot of whiskey\n";

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
        while (true) {
            Scanner scan = new Scanner(System.in);
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println(falseInputMessage);
            }
            int input = scan.nextInt();
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
