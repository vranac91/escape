package ui.levels;

import helpers.LevelHandler;
import helpers.Print;

import java.util.Scanner;

public class Door implements LevelHandler {
    private final String DOOR_TEXT = "...\n...\nOw...\n.......\n\"Ow...my head...\"\n\"...My...what...wh...where am I?\"\n...\n" +
            "You wake up at the floor; your head feels like it's about to explode.\n" +
            "Slowly, you start to get up. You feel like a tank ran you over. You have no memory how you got here, or where you are.\n" +
            "As you get up, your legs start to shake. Your vision is blurry - you rub your eyes and start to look around the room, trying not to fall down.\n" +
            "You realize that you're in someone's office room. There is a big desk, a couch, and a big closet along with the bookshelf.\n" +
            "You can't see very good, since the main light is out. The only light source comes through a half-opened window; seems like that's a street lamp.\n" +
            "Right in front of you, you see a door. You start to walk towards it and step into a puddle.\n" +
            "You look down, and realize that it's blood.\n" +
            "\"Oh God! What?! What's happening?!\"\n" +
            "Shocked and scared, you decide that it's time to leave this room and find out what happened to you.\n";
    private final String DOOR_CHOICES = "[1] Walk towards the door and try to open it\n";

    @Override
    public void printLevelText() {
        System.out.println(DOOR_TEXT);
    }

    @Override
    public void printLevelChoices() {
        System.out.println(DOOR_CHOICES);
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
                NoteAndWindow noteAndWindow = new NoteAndWindow();
                noteAndWindow.start();
                break;
            } else {
                System.out.print(falseInputMessage);
            }
        }
    }

    @Override
    public void start() {
        Print.printDivider();
        printLevelText();
        printLevelChoices();
        handleChoices();
    }

}

