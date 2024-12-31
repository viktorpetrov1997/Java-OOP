package WorkingWithAbstraction.Exercises.CardSuit;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        CardSuit[] cardSuits = CardSuit.values();

        System.out.println("Card Suits:");
        for(CardSuit card : cardSuits)
        {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
        }
    }
}
