import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Full name
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        // Favorite language
        System.out.print("Enter your favorite programming language: ");
        String favLang = scanner.nextLine();

        // Sentence
        System.out.print("Enter a sentence about your programming experience: ");
        String sentence = scanner.nextLine();

        // 1. Extract first and last name
        String[] parts = fullName.split(" ");
        String firstName = parts[0];
        String lastName = parts.length > 1 ? parts[1] : "";

        // 2. Count characters in sentence (excluding spaces)
        int charCount = 0;
        for (char c : sentence.toCharArray()) {
            if (c != ' ') charCount++;
        }

        // 3. Convert programming language to uppercase
        String langUpper = favLang.toUpperCase();

        // 4. Display formatted summary
        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + langUpper);
        System.out.println("Character count in sentence (excluding spaces): " + charCount);

        scanner.close();
    }
}
