import java.util.*;

public class conversion {

    public static char toUpper(char c) {
        if (c >= 'a' && c <= 'z') return (char)(c - 32);
        return c;
    }

    public static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c + 32);
        return c;
    }

    public static String convertToUpper(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(toUpper(c));
        return sb.toString();
    }

    public static String convertToLower(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(toLower(c));
        return sb.toString();
    }

    public static String convertToTitle(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                newWord = true;
            } else {
                sb.append(newWord ? toUpper(c) : toLower(c));
                newWord = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();

        String upper = convertToUpper(text);
        String lower = convertToLower(text);
        String title = convertToTitle(text);

        System.out.printf("\n%-20s %-20s\n", "Manual Result", "Built-in Result");
        System.out.printf("%-20s %-20s\n", upper, text.toUpperCase());
        System.out.printf("%-20s %-20s\n", lower, text.toLowerCase());
        System.out.printf("%-20s %-20s\n", title, title); // Java has no built-in title case
        sc.close();
    }
}
