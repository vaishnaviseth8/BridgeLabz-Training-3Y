package Strings;

public class NullPointerDemo {

    public static void generateException() {
        String text = null;
        int length = text.length();
        System.out.println("Length: " + length);
    }

    public static void handleException() {
        String text = null;
        try {
            int length = text.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: text is null!");
        }
    }

    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception generated: " + e);
        }

        handleException();
    }
}


