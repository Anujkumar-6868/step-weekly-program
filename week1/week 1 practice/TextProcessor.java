import java.util.*;

public class TextProcessor {
    // Method to clean input
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " "); // remove extra spaces
        return input;
    }

    // Method to analyze text
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replace(" ", "").length();
        int sentenceCount = text.split("[.!?]").length;

        // Find longest word
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        // Find most common character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (c != ' ' && Character.isLetter(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        char mostCommon = ' ';
        int max = 0;
        for (var entry : freq.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        System.out.println("\n--- Analysis ---");
        System.out.println("Words: " + wordCount);
        System.out.println("Characters (excluding spaces): " + charCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Longest Word: " + longest);
        System.out.println("Most Common Character: " + mostCommon);
    }

    // Method to get words sorted
    public static String[] getWordsSorted(String text) {
        String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String paragraph = scanner.nextLine();

        String cleaned = cleanInput(paragraph);
        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\n--- Words in Alphabetical Order ---");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nEnter a word to search: ");
        String search = scanner.nextLine().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(search);
        System.out.println("Word found? " + found);

        scanner.close();
    }
}
