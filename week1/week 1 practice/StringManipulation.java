public class StringManipulation {
    public static void main(String[] args) {
        // 1. String literal
        String str1 = "Java Programming";

        // 2. new String() constructor
        String str2 = new String("Java Programming");

        // 3. Character array
        char[] chars = {'J','a','v','a',' ','P','r','o','g','r','a','m','m','i','n','g'};
        String str3 = new String(chars);

        // Compare using ==
        System.out.println("str1 == str2 ? " + (str1 == str2));
        System.out.println("str1 == str3 ? " + (str1 == str3));

        // Compare using equals()
        System.out.println("str1.equals(str2) ? " + str1.equals(str2));
        System.out.println("str1.equals(str3) ? " + str1.equals(str3));

        System.out.println("\n--- String with escape sequences ---");
        String quote = "Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects";
        System.out.println(quote);
    }
}
