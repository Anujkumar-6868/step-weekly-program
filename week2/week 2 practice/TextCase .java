import java.util.Scanner;

public class TextCase {

    public static char toUpper(char c) {
        if (c >= 'a' && c <= 'z') return (char)(c - 32);
        return c;
    }

    public static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c + 32);
        return c;
    }

    public static String convertUpper(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) sb.append(toUpper(c));
        return sb.toString();
    }

    public static String convertLower(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) sb.append(toLower(c));
        return sb.toString();
    }

    public static String convertTitle(String str) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                newWord = true;
            } else {
                if (newWord) {
                    sb.append(toUpper(c));
                    newWord = false;
                } else {
                    sb.append(toLower(c));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String manualUpper = convertUpper(text);
        String manualLower = convertLower(text);
        String manualTitle = convertTitle(text);

        System.out.println("\nManual Uppercase: " + manualUpper);
        System.out.println("Built-in Uppercase: " + text.toUpperCase());

        System.out.println("\nManual Lowercase: " + manualLower);
        System.out.println("Built-in Lowercase: " + text.toLowerCase());

        System.out.println("\nManual Title Case: " + manualTitle);
    }
}
