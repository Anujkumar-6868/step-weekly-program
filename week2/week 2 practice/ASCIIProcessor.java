import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Process each character
        for (char ch : input.toCharArray()) {
            int ascii = (int) ch;
            System.out.println("Character: '" + ch + "' | ASCII: " + ascii);

            // Classify character
            String type = classifyCharacter(ch);
            System.out.println("Type: " + type);

            // If it's a letter, show case conversions
            if (Character.isLetter(ch)) {
                char toggled = toggleCase(ch);
                System.out.println("Toggle Case: " + toggled + " | ASCII: " + (int) toggled);
                System.out.println("Difference between upper and lower: " + Math.abs('A' - 'a'));
            }

            System.out.println("----------------------");
        }

        // Create ASCII Table
        System.out.println("\n=== ASCII TABLE (65–90) ===");
        displayASCIITable(65, 90);

        // Demonstrate Caesar cipher
        System.out.print("\nEnter text to encrypt (Caesar Cipher): ");
        String text = scanner.nextLine();
        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();
        String encrypted = caesarCipher(text, shift);
        System.out.println("Encrypted: " + encrypted);

        // Convert string to ASCII and back
        int[] asciiArray = stringToASCII(text);
        System.out.print("\nASCII Array: ");
        for (int val : asciiArray) System.out.print(val + " ");
        System.out.println("\nBack to String: " + asciiToString(asciiArray));

        scanner.close();
    }

    // Classify character type
    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    // Convert case using ASCII
    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32);
        else if (Character.isLowerCase(ch)) return (char) (ch - 32);
        else return ch;
    }

    // Caesar Cipher
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Display ASCII table
    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    // String → ASCII array
    public static int[] stringToASCII(String text) {
        int[] ascii = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            ascii[i] = (int) text.charAt(i);
        }
        return ascii;
    }

    // ASCII array → String
    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) {
            sb.append((char) val);
        }
        return sb.toString();
    }
}
