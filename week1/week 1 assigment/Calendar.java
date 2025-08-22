import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        if (month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            days[1] = 29;

        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31*m0)/12) % 7;

        System.out.println("\n   " + months[month-1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < d0; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days[month-1]; day++) {
            System.out.printf("%3d ", day);
            if ((day + d0) % 7 == 0) System.out.println();
        }
    }
}
