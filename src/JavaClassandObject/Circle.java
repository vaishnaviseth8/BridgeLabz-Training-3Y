package JavaClassandObject;

public class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display() {
        System.out.printf("Radius         : %.2f\n", radius);
        System.out.printf("Area           : %.2f\n", calculateArea());
        System.out.printf("Circumference  : %.2f\n", calculateCircumference());
    }

    public static void main(String[] args) {
        Circle c = new Circle(5.5);
        c.display();
    }
}

