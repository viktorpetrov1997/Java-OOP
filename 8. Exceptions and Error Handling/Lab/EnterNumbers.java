package ExceptionsAndErrorHandling.Lab;

import java.util.ArrayList;
import java.util.Scanner;

public class EnterNumbers
{
    public static int readNumber(int start, int end, Scanner scanner)
    {
        while(true)
        {
            try
            {
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                if(number <= start || number >= end)
                {
                    System.out.printf("Your number is not in range %d - %d!%n", start, end);
                }
                else
                {
                    return number;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid Number!");
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> validNumbers = new ArrayList<>();

        int start = 1;
        int end = 100;

        while (validNumbers.size() < 10)
        {
            int currentStart = (validNumbers.isEmpty()) ? start : validNumbers.get(validNumbers.size() - 1);
            int number = readNumber(currentStart, end, scanner);
            validNumbers.add(number);
        }

        System.out.println(String.join(", ", validNumbers.stream().map(String::valueOf).toArray(String[]::new)));
    }
}
