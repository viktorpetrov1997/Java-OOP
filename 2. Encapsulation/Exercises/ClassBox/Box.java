package Encapsulation.Exercises.ClassBox;

public class Box
{
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height)
    {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length)
    {
        if(length <= 0)
        {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public void setWidth(double width)
    {
        if(width <= 0)
        {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(double height)
    {
        if(height <= 0)
        {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea()
    {
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateLateralSurfaceArea()
    {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateVolume()
    {
        return this.length * this.width * this.height;
    }
}
