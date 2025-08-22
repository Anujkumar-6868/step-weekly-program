import java.util.Scanner;

public class UniqueChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (Exception e) {}

        char[] unique = new char[length];
        int uIndex = 0;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (ch == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[uIndex++] = ch;
            }
        }

        System.out.print("Unique characters: ");
        for (int i = 0; i < uIndex; i++) {
            System.out.print(unique[i] + " ");
        }
    }
}
