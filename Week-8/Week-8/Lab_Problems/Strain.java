public class Strain {
    abstract static class Shape {
        double area, perimeter;
        public abstract void calculateArea();
        public abstract void calculatePerimeter();
    }
    interface Drawable {
        void draw();
    }
    static class Circle extends Shape implements Drawable {
        double radius;
        public Circle(double radius) { this.radius = radius; }
        public void calculateArea() { area = Math.PI * radius * radius; }
        public void calculatePerimeter() { perimeter = 2 * Math.PI * radius; }
        public void draw() {
            System.out.println("Drawing a circle of radius " + radius);
        }
    }
    public static void main(String[] args) {
        Circle circle = new Circle(3.0);
        circle.calculateArea();
        circle.calculatePerimeter();
        circle.draw();
        System.out.println("Area: " + circle.area);
        System.out.println("Perimeter: " + circle.perimeter);
    }
}
