package Polymorphism.Exercises.CalculatorSecondWay;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        ArrayDeque<Integer> memory = new ArrayDeque<>();
        String currentOperation = null;

        while(true)
        {
            String input = scanner.next();

            if(input.equals("end"))
            {
                break;
            }

            if(input.matches("\\d+"))
            {
                int number = Integer.parseInt(input);

                if(currentOperation != null)
                {
                    if(currentOperation.equals("*"))
                    {
                        result *= number;
                    }
                    else if(currentOperation.equals("/"))
                    {
                        result /= number;
                    }
                    currentOperation = null;
                }
                else
                {
                    result = number;
                }
            }
            else
            {
                if(input.equals("*") || input.equals("/"))
                {
                    currentOperation = input;
                }
                else if(input.equals("ms"))
                {
                    memory.push(result);
                }
                else if(input.equals("mr"))
                {
                    if(!memory.isEmpty())
                    {
                        int recalledValue = memory.pop();
                        if(currentOperation != null)
                        {
                            if(currentOperation.equals("*"))
                            {
                                result *= recalledValue;
                            }
                            else if(currentOperation.equals("/"))
                            {
                                result /= recalledValue;
                            }
                            currentOperation = null;
                        }
                        else
                        {
                            result = recalledValue;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
