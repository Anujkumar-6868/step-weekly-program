import java.util.Scanner;

public class FirstNonRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char result = ' ';
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                result = text.charAt(i);
                break;
            }
        }

        if (result == ' ')
            System.out.println("No non-repeating character found.");
        else
            System.out.println("First non-repeating character: " + result);
    }
}
