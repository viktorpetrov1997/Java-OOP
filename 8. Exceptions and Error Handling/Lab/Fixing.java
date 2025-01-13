package ExceptionsAndErrorHandling.Lab;

import java.util.Scanner;

public class Fixing
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] weekdays = new String[5];

        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        try
        {
            for(int i = 0; i <= weekdays.length; i++)
            {
                System.out.println(weekdays[i]);
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error: Tried to access an invalid index in the array.");
        }

        try
        {
            System.out.println("Press Enter to exit.");
            scanner.nextLine();
        }
        catch(Exception e)
        {
            System.out.println("Error: Something went wrong while reading input.");
        }
    }
}
