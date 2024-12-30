package WorkingWithAbstraction.Lab.PointOfRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int bottomLeftX = rectangleCoordinates[0];
        int bottomLeftY = rectangleCoordinates[1];
        int topRightX = rectangleCoordinates[2];
        int topRightY = rectangleCoordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int numberOfPoints = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfPoints; i++)
        {
            int[] pointCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Point point = new Point(pointCoordinates[0], pointCoordinates[1]);

            System.out.println(rectangle.contains(point));
        }
    }
}
