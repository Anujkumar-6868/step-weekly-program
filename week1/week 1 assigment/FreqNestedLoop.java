import java.util.Scanner;

public class FreqNestedLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] arr = text.toCharArray();
        int[] freq = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') continue;
            freq[i] = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    freq[i]++;
                    arr[j] = '0';
                }
            }
        }

        System.out.println("Character frequencies:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0') {
                System.out.println(arr[i] + " -> " + freq[i]);
            }
        }
    }
}
