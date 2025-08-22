import java.util.Scanner;

public class WordLengthTableEasy {
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

        // 2D array [word, length]
        String[][] table = new String[words.size()][2];
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int len = 0;
            try {
                while (true) {
                    word.charAt(len);
                    len++;
                }
            } catch (Exception e) {}
            table[i][0] = word;
            table[i][1] = String.valueOf(len);
        }

        // Display
        System.out.println("\nWord\tLength");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }

        sc.close();
    }
}
