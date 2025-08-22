import java.util.Scanner;

public class ShortestLongestEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        // Manual split
        String temp = "";
        java.util.ArrayList<String> words = new java.util.ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (!temp.equals("")) {
                    words.add(temp);
                    temp = "";
                }
            } else {
                temp += c;
            }
        }
        if (!temp.equals("")) words.add(temp);

        // Find shortest & longest
        String shortest = words.get(0);
        String longest = words.get(0);

        for (String w : words) {
            if (w.length() < shortest.length()) shortest = w;
            if (w.length() > longest.length()) longest = w;
        }

        System.out.println("\nShortest word: " + shortest + " (length " + shortest.length() + ")");
        System.out.println("Longest word: " + longest + " (length " + longest.length() + ")");

        sc.close();
    }
}
