import java.util.Scanner;

public class FindReplace {

    // Method to find all occurrences
    public static int[] findOccurrences(String text, String find) {
        int index = text.indexOf(find);
        int count = 0;
        int[] positions = new int[text.length()];
        
        while (index != -1) {
            positions[count++] = index;
            index = text.indexOf(find, index + find.length());
        }
        int[] result = new int[count];
        System.arraycopy(positions, 0, result, 0, count);
        return result;
    }

    // Method to manually replace
    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
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

    // Compare with built-in
    public static boolean compareResults(String manual, String builtin) {
        return manual.equals(builtin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter substring to find: ");
        String find = sc.nextLine();
        System.out.print("Enter replacement substring: ");
        String replace = sc.nextLine();

        int[] positions = findOccurrences(text, find);
        System.out.print("Occurrences at: ");
        for (int pos : positions) System.out.print(pos + " ");
        System.out.println();

        String manual = manualReplace(text, find, replace);
        String builtin = text.replace(find, replace);

        System.out.println("Manual Replace: " + manual);
        System.out.println("Built-in Replace: " + builtin);
        System.out.println("Are both equal? " + compareResults(manual, builtin));
    }
}
