public class Grain {
    abstract static class Employee {
        protected String name;
        protected double salary;
        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
        public abstract double calculateBonus();
    }
    interface Payable {
        void generatePaySlip();
    }
    static class Manager extends Employee implements Payable {
        public Manager(String name, double salary) {
            super(name, salary);
        }
        public double calculateBonus() {
            return salary * 0.20;
        }
        public void generatePaySlip() {
            System.out.println("Pay Slip: " + name + ", Salary: " + salary + ", Bonus: " + calculateBonus());
        }
    }
    public static void main(String[] args) {
        Manager m = new Manager("Alice", 50000);
        m.generatePaySlip();
    }
}
