package helpers;

public class Print {
    public static void printTextByChar(String string, int speedInMillis) {
        for (char c : string.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(speedInMillis);
            } catch (Exception e) {
                System.out.println("Error in printing string by char!");
            }
        }
    }

    public static void printDivider() {
        System.out.println();
        for (int i = 1; i < 30; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
