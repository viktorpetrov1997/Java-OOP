package WorkingWithAbstraction.Lab.PointOfRectangle;

public class Rectangle
{
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight)
    {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point otherPoint)
    {
        boolean isXInside = this.bottomLeft.getX() <= otherPoint.getX() && this.topRight.getX() >= otherPoint.getX();

        boolean isYInside = this.bottomLeft.getY() <= otherPoint.getY() && this.topRight.getY() >= otherPoint.getY();

        return  isXInside && isYInside;
    }
}
