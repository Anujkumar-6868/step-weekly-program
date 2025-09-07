// Assignment6_Payroll.java
class Employee {
    String empId, empName, department, designation;
    double baseSalary;
    boolean[] attendance;

    static int totalEmployees = 0;
    static String companyName = "TechCorp";

    Employee(String id, String name, String dept, String desig, double sal) {
        empId = id; empName = name; department = dept;
        designation = desig; baseSalary = sal;
        attendance = new boolean[30];
        totalEmployees++;
    }

    void markAttendance(int day, boolean present) {
        attendance[day - 1] = present;
    }

    double calculateSalary() {
        int presentDays = 0;
        for (boolean b : attendance) if (b) presentDays++;
        return baseSalary * presentDays / 30;
    }

    void generatePaySlip() {
        System.out.println("PaySlip: " + empName + " | Salary: " + calculateSalary());
    }
}

public class Payroll {
    public static void main(String[] args) {
        Employee e1 = new Employee("E1", "Ravi", "IT", "Dev", 30000);
        for (int i = 1; i <= 28; i++) e1.markAttendance(i, true);
        e1.generatePaySlip();
    }
}
