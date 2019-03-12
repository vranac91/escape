package ui.levels;

import helpers.HelperMethods;
import helpers.LevelHandler;

public class Door implements LevelHandler {
    private final String DOOR_TEXT = "...\n..\n...\n\"Ow...\"\n.......\n\"Ow...my head...\"\n\n\"...My...what...wh...where am I?\"\n...\n\n" +
            "You wake up at the floor; your head feels like it's about to explode.\n" +
            "Slowly, you start to get up. You feel like a tank ran you over. You have no memory how you got here, or where you are.\n\n" +
            "As you get up, your legs start to shake. Your vision is blurry - you rub your eyes and start to look around the room, trying not to fall down.\n\n" +
            "You realize that you're in someone's office room. There is a big desk, a couch, and a big closet along with the bookshelf.\n" +
            "You can't see very good, since the main light is out. The only light source comes through a half-opened window; seems like that's a street lamp.\n\n" +
            "Right in front of you, you see a door. You start to walk towards it and step into a puddle.\n" +
            "You look down, and realize that it's blood.\n\n" +
            "\"Oh God! What?! What's happening?!\"\n\n" +
            "Shocked and scared, you decide that it's time to leave this room and find out what happened to you.\n\n";
    private final String DOOR_CHOICES = "[1] Walk towards the door and try to open it\n";

    @Override
    public void printLevelText() {
        HelperMethods.printTextByChar(DOOR_TEXT, 30);
    }

    @Override
    public void printLevelChoices() {
        HelperMethods.printTextByChar(DOOR_CHOICES, 30);
    }

    @Override
    public void handleChoices() {
        while (true) {
            int input = HelperMethods.validateIntInput();
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
        HelperMethods.printDivider();
        printLevelText();
        printLevelChoices();
        handleChoices();
    }

}

