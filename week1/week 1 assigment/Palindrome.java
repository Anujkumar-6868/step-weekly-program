import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Logic 1
        boolean isPalindrome = true;
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("Logic 1: " + (isPalindrome ? "Palindrome" : "Not Palindrome"));

        // Logic 2 (Recursion)
        System.out.println("Logic 2: " + (checkRecursive(text, 0, text.length() - 1) ? "Palindrome" : "Not Palindrome"));

        // Logic 3 (Reverse string)
        String rev = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            rev += text.charAt(i);
        }
        System.out.println("Logic 3: " + (text.equals(rev) ? "Palindrome" : "Not Palindrome"));
    }

    static boolean checkRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return checkRecursive(s, start + 1, end - 1);
    }
}
