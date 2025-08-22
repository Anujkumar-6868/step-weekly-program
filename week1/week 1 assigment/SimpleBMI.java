import java.util.Scanner;

public class SimpleBMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] persons = new double[10][2]; // [weight, height]
        String[][] results = new String[10][4]; // [height, weight, BMI, status]

        // Take input
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            persons[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            persons[i][1] = sc.nextDouble();
        }

        // Calculate BMI and status
        for (int i = 0; i < 10; i++) {
            double weight = persons[i][0];
            double heightM = persons[i][1] / 100; // convert cm to meters
            double bmi = weight / (heightM * heightM);

            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 24.9) status = "Normal";
            else if (bmi < 29.9) status = "Overweight";
            else status = "Obese";

            results[i][0] = String.valueOf(persons[i][1]); // height
            results[i][1] = String.valueOf(weight);        // weight
            results[i][2] = String.format("%.2f", bmi);    // BMI
            results[i][3] = status;                        // Status
        }

        // Display results
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.println(results[i][0] + "\t\t" + results[i][1] +
                               "\t\t" + results[i][2] + "\t" + results[i][3]);
        }

        sc.close();
    }
}
