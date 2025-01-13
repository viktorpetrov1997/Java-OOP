package ExceptionsAndErrorHandling.Lab;

import java.util.Scanner;

public class NumberInRange
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split(" ");
        int lowerBound = Integer.parseInt(range[0]);
        int upperBound = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]%n", lowerBound, upperBound);

        while(true)
        {
            String input = scanner.nextLine();
            try
            {
                int number = Integer.parseInt(input);
                if(number >= lowerBound && number <= upperBound)
                {
                    System.out.printf("Valid number: %d%n", number);
                    break;
                }
                else
                {
                    System.out.printf("Invalid number: %d%n", number);
                }
            }
            catch(NumberFormatException e)
            {
                System.out.printf("Invalid number: %s%n", input);
            }
        }
    }
}
