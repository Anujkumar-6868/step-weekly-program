public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        // String concatenation
        long start = System.nanoTime();
        String strResult = concatenateWithString(10000);
        long end = System.nanoTime();
        System.out.println("String time: " + (end - start) + " ns");

        // StringBuilder
        start = System.nanoTime();
        String sbResult = concatenateWithStringBuilder(10000);
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");

        // StringBuffer
        start = System.nanoTime();
        String sbfResult = concatenateWithStringBuffer(10000);
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");

        // Demonstrate StringBuilder methods
        demonstrateStringBuilderMethods();

        // Compare string comparison methods
        compareStringComparisonMethods();

        // Thread safety demo
        demonstrateThreadSafety();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java" + i;
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        System.out.println("\n=== StringBuilder Methods ===");
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append(" Java"); 
        sb.insert(6, "Beautiful "); 
        sb.delete(6, 16); 
        sb.deleteCharAt(5); 
        sb.reverse(); 
        sb.reverse();
        sb.replace(0, 5, "Hi");
        sb.setCharAt(0, 'Y');
        System.out.println("Final String: " + sb);
        System.out.println("Capacity: " + sb.capacity());
        sb.ensureCapacity(50);
        sb.trimToSize();
    }

    public static void demonstrateThreadSafety() {
        System.out.println("\n=== Thread Safety Demo ===");
        StringBuffer sbf = new StringBuffer("Start");
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                sbf.append("X");
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
        try { t1.join(); t2.join(); } catch (Exception e) {}
        System.out.println("StringBuffer length (safe): " + sbf.length());
    }

    public static void compareStringComparisonMethods() {
        System.out.println("\n=== String Comparison ===");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.equalsIgnoreCase(\"hello\"): " + str1.equalsIgnoreCase("hello"));
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3));
        System.out.println("str1.compareToIgnoreCase(\"hello\"): " + str1.compareToIgnoreCase("hello"));
    }
}
