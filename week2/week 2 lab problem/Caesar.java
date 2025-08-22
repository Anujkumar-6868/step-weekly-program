import java.util.*;

public class Caesar {

    public static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char)('A' + (c - 'A' + shift) % 26));
            } else if (c >= 'a' && c <= 'z') {
                sb.append((char)('a' + (c - 'a' + shift) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void displayAscii(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c + "(" + (int)c + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to encrypt: ");
        String text = sc.nextLine();

        System.out.println("Enter shift value: ");
        int shift = sc.nextInt();

        System.out.println("\nOriginal Text with ASCII:");
        displayAscii(text);

        String encrypted = encrypt(text, shift);
        System.out.println("Encrypted Text with ASCII:");
        displayAscii(encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted Text with ASCII:");
        displayAscii(decrypted);

        System.out.println("\nDecryption Successful? " + text.equals(decrypted));
        sc.close();
    }
}
