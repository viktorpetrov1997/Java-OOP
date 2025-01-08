package Polymorphism.Lab.Shapes;

public class Main
{
    public static void main(String[] args)
    {
        Rectangle rectangle = new Rectangle(4, 5);
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());
        System.out.println("Rectangle Area: " + rectangle.getArea());

        Circle circle = new Circle(3);
        System.out.println("Circle Perimeter: " + circle.getPerimeter());
        System.out.println("Circle Area: " + circle.getArea());
    }
}