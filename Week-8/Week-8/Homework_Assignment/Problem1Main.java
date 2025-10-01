public class Problem1Main {
    abstract static class Shape {
        public abstract double area();
        public abstract double perimeter();

        public void displayInfo() {
            System.out.println("This is a shape.");
        }
    }

    static class Circle extends Shape {
        double radius;
        Circle(double radius) { this.radius = radius; }
        public double area() { return Math.PI * radius * radius; }
        public double perimeter() { return 2 * Math.PI * radius; }
    }

    static class Rectangle extends Shape {
        double length, width;
        Rectangle(double length, double width) { this.length = length; this.width = width; }
        public double area() { return length * width; }
        public double perimeter() { return 2 * (length + width); }
    }

    public static void main(String[] args) {
        Shape s1 = new Circle(5.0);
        s1.displayInfo();
        System.out.println("Circle Area: " + s1.area());
        System.out.println("Circle Perimeter: " + s1.perimeter());

        Shape s2 = new Rectangle(4.0, 7.0);
        s2.displayInfo();
        System.out.println("Rectangle Area: " + s2.area());
        System.out.println("Rectangle Perimeter: " + s2.perimeter());
    }
}
