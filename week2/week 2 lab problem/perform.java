import java.util.*;

public class perform {

    public static long testString(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("String Length: " + s.length());
        return end - start;
    }

    public static long testBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("Builder Length: " + sb.length());
        return end - start;
    }

    public static long testBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("Buffer Length: " + sb.length());
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of iterations: ");
        int n = sc.nextInt();

        long t1 = testString(n);
        long t2 = testBuilder(n);
        long t3 = testBuffer(n);

        System.out.printf("\n%-15s %-15s\n", "Method", "Time (ms)");
        System.out.printf("%-15s %-15d\n", "String", t1);
        System.out.printf("%-15s %-15d\n", "StringBuilder", t2);
        System.out.printf("%-15s %-15d\n", "StringBuffer", t3);
        sc.close();
    }
}
