package ui.levels;

import helpers.LevelHandler;
import helpers.HelperMethods;

import java.util.Scanner;

public class ManAndDog implements LevelHandler {
    private final String LEVEL_TEXT = "You wave to the man, crying for help, hoping that he will respond.\n" +
            "Suddenly, both the man and the dog freeze, perfectly synced.\n\nThey both start slowly turning their heads to you.\n\n" +
            "As they turn, you realize that both the dog and the man have glowing, devilish red eyes.\n\n" +
            "\"WHAT?!\"\n\n" +
            "You are paralyzed with fear. They both look at you and stand perfectly still. Suddenly, a man lets out a horrific, otherworldly shriek.\n\n" +
            "This doesn't look good. There must be a way to call for help. You need to act quickly.\n";
    private final String LEVEL_CHOICES = "[1] Duck and wait for a bit, then peek and check for the man and dog\n[2] Duck, crawl and look for the telephone\n";

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
                Peek peek = new Peek();
                peek.start();
                break;
            } else if (input == 2) {
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
