package Polymorphism.Lab.Shapes;

public class Rectangle extends Shape
{
    private double height;
    private double width;

    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWidth()
    {
        return width;
    }

    @Override
    protected double calculateArea()
    {
        return width * height;
    }

    @Override
    protected double calculatePerimeter()
    {
        return 2 * (width + height);
    }
}
