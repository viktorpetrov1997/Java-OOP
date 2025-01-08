package Polymorphism.Lab.Shapes;

public abstract class Shape
{
    private double perimeter = 0.0;
    private double area = 0.0;

    public double getArea()
    {
        if(area == 0.0)
        {
            area = calculateArea();
        }
        return area;
    }

    public double getPerimeter()
    {
        if(perimeter == 0.0)
        {
            perimeter = calculatePerimeter();
        }
        return perimeter;
    }

    protected abstract double calculateArea();

    protected abstract double calculatePerimeter();
}
