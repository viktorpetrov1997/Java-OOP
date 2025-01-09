package Polymorphism.Exercises.WordSecondWay;

import java.util.Scanner;

public class WordProcessor
{
    public static void toUpperCase(StringBuilder text, int startIndex, int endIndex)
    {
        for(int i = startIndex; i < endIndex; i++)
        {
            text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
        }
    }

    public static String cutText(StringBuilder text, int startIndex, int endIndex)
    {
        if(startIndex == endIndex)
        {
            return "";
        }

        String cut = text.substring(startIndex, endIndex);
        text.delete(startIndex, endIndex);
        return cut;
    }

    public static void pasteText(StringBuilder text, int startIndex, int endIndex, String lastCut)
    {
        if(!lastCut.isEmpty())
        {
            text.replace(startIndex, endIndex, lastCut);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        String lastCut = "";

        String input = scanner.nextLine();
        while(!input.equals("exit"))
        {
            String[] inputData = input.split("\\s+");

            String commandName = inputData[0];
            int startIndex = Integer.parseInt(inputData[1]);
            int endIndex = Integer.parseInt(inputData[2]);

            switch(commandName)
            {
                case "uppercase":
                    toUpperCase(text, startIndex, endIndex);
                    break;

                case "cut":
                    lastCut = cutText(text, startIndex, endIndex);
                    break;

                case "paste":
                    pasteText(text, startIndex, endIndex, lastCut);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(text);
    }
}

