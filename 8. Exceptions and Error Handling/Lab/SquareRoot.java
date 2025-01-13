package ExceptionsAndErrorHandling.Lab;

import java.util.Scanner;

public class SquareRoot
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try
        {
            int number = Integer.parseInt(input);
            System.out.printf("%.2f%n", Math.sqrt(number));
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid");
        }
        finally
        {
            System.out.println("Goodbye");
        }
    }
}
