package WorkingWithAbstraction.Exercises.CardRank;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        CardRank[] cardRanks = CardRank.values();

        System.out.println("Card Ranks:");
        for(CardRank card : cardRanks)
        {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
        }
    }
}
