import java.util.Scanner;

public class Performance {

    public static long testString(int n) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) str += "X";
        long end = System.currentTimeMillis();
        System.out.println("String length: " + str.length());
        return end - start;
    }

    public static long testStringBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("X");
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder length: " + sb.length());
        return end - start;
    }

    public static long testStringBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append("X");
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer length: " + sb.length());
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();

        long t1 = testString(n);
        long t2 = testStringBuilder(n);
        long t3 = testStringBuffer(n);

        System.out.println("\n--- Performance Comparison ---");
        System.out.println("Method         | Time (ms)");
        System.out.println("String         | " + t1);
        System.out.println("StringBuilder  | " + t2);
        System.out.println("StringBuffer   | " + t3);
    }
}
