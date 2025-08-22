import java.util.Scanner;

public class StringLengthEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // loop stops when exception occurs
        }

        System.out.println("Length (manual) : " + count);
        System.out.println("Length (built-in): " + str.length());

        sc.close();
    }
}
