package Polymorphism.Lab.Shapes;

public class Circle extends Shape
{
    private double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public final double getRadius()
    {
        return radius;
    }

    @Override
    protected double calculateArea()
    {
        return Math.PI * radius * radius;
    }

    @Override
    protected double calculatePerimeter()
    {
        return 2 * Math.PI * radius;
    }
}
