class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;
    private static int counter = 1;

    public Employee(String empName, String department, double baseSalary, String empType) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary;
        this.empType = empType;
        totalEmployees++;
    }

    private static String generateEmpId() {
        return "E" + String.format("%03d", counter++);
    }

    // Overloaded salary calculation
    public double calculateSalary(double bonus) {
        return baseSalary + bonus; // Full-time
    }

    public double calculateSalary(double hourlyRate, int hours) {
        return hourlyRate * hours; // Part-time
    }

    public double calculateSalary() {
        return baseSalary; // Contract
    }

    // Overloaded tax calculation
    public double calculateTax(double salary, double rate) {
        return salary * rate / 100;
    }

    public void generatePaySlip(double salary, double tax) {
        System.out.println(empId + " - " + empName + " (" + empType + ")");
        System.out.println("Department: " + department + ", Salary: " + salary + ", Tax: " + tax);
        System.out.println("------------------------------------");
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "IT", 50000, "Full-time");
        Employee e2 = new Employee("Bob", "HR", 0, "Part-time");
        Employee e3 = new Employee("Charlie", "Finance", 30000, "Contract");

        double s1 = e1.calculateSalary(10000);
        double t1 = e1.calculateTax(s1, 10);
        e1.generatePaySlip(s1, t1);

        double s2 = e2.calculateSalary(500, 80);
        double t2 = e2.calculateTax(s2, 5);
        e2.generatePaySlip(s2, t2);

        double s3 = e3.calculateSalary();
        double t3 = e3.calculateTax(s3, 8);
        e3.generatePaySlip(s3, t3);

        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}
