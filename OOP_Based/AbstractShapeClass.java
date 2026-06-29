// Abstract class
abstract class Shape {

    // Abstract method
    abstract double calculateArea();

    // Common display method
    public void displayArea() {

        System.out.println(
                "Area = " + calculateArea()
        );
    }
}

// Circle subclass
class Circle extends Shape {

    private double radius;

    // Constructor
    public Circle(double radius) {

        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1;
        }
    }

    // Override calculateArea
    @Override
    double calculateArea() {

        return Math.PI * radius * radius;
    }
}

// Rectangle subclass
class Rectangle extends Shape {

    private double length;
    private double width;

    // Constructor
    public Rectangle(double length,
                     double width) {

        if (length > 0) {
            this.length = length;
        } else {
            this.length = 1;
        }

        if (width > 0) {
            this.width = width;
        } else {
            this.width = 1;
        }
    }

    // Override calculateArea
    @Override
    double calculateArea() {

        return length * width;
    }
}

// Main class
public class AbstractShapeClass {

    public static void main(String[] args) {

        // Circle object
        Shape circle =
                new Circle(5);

        System.out.println(
                "Circle Area"
        );

        circle.displayArea();

        System.out.println();

        // Rectangle object
        Shape rectangle =
                new Rectangle(10, 4);

        System.out.println(
                "Rectangle Area"
        );

        rectangle.displayArea();
    }
}