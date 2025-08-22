import java.util.Scanner;

public class SplitCompareEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        // Manual split
        String temp = "";
        java.util.ArrayList<String> manualList = new java.util.ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (!temp.equals("")) {
                    manualList.add(temp);
                    temp = "";
                }
            } else {
                temp += c;
            }
        }
        if (!temp.equals("")) manualList.add(temp);

        String[] manualSplit = manualList.toArray(new String[0]);

        // Built-in split
        String[] builtInSplit = text.split(" ");

        // Compare
        boolean same = true;
        if (manualSplit.length != builtInSplit.length) same = false;
        else {
            for (int i = 0; i < manualSplit.length; i++) {
                if (!manualSplit[i].equals(builtInSplit[i])) {
                    same = false;
                    break;
                }
            }
        }

        // Display
        System.out.println("Manual split:");
        for (String w : manualSplit) System.out.println(w);

        System.out.println("\nBuilt-in split:");
        for (String w : builtInSplit) System.out.println(w);

        System.out.println("\nAre both same? " + same);

        sc.close();
    }
}
