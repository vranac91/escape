package helpers;

public interface LevelHandler {
    String falseInputMessage = "Please input a number next to your desired choice.";

    void printLevelText();

    void printLevelChoices();

    void handleChoices();

    void start();
}
