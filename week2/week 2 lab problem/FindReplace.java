import java.util.*;

public class FindReplace {

    // Method to find all occurrences of a substring
    public static int[] findOccurrences(String text, String find) {
        int index = text.indexOf(find);
        ArrayList<Integer> positions = new ArrayList<>();
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(find, index + 1);
        }
        return positions.stream().mapToInt(i -> i).toArray();
    }

    // Method to manually replace substring
    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length();) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    // Compare with built-in replace()
    public static boolean compareWithBuiltIn(String original, String find, String replace) {
        String manual = manualReplace(original, find, replace);
        String builtIn = original.replace(find, replace);
        return manual.equals(builtIn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter main text: ");
        String text = sc.nextLine();

        System.out.println("Enter substring to find: ");
        String find = sc.nextLine();

        System.out.println("Enter substring to replace: ");
        String replace = sc.nextLine();

        int[] positions = findOccurrences(text, find);
        String manualResult = manualReplace(text, find, replace);
        boolean isSame = compareWithBuiltIn(text, find, replace);

        System.out.println("\nOriginal Text: " + text);
        System.out.print("Occurrences found at positions: ");
        for (int pos : positions) System.out.print(pos + " ");
        System.out.println("\n\nManual Replace Result: " + manualResult);
        System.out.println("Built-in Replace Result: " + text.replace(find, replace));
        System.out.println("Comparison: " + (isSame ? "Both are same ✅" : "Different ❌"));
        sc.close();
    }
}
