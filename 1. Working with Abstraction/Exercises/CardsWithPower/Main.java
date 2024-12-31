package WorkingWithAbstraction.Exercises.CardsWithPower;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        CardRank rank = CardRank.valueOf(cardRank);
        CardSuit suit = CardSuit.valueOf(cardSuit);

        Card card = new Card(rank, suit);
        System.out.println(card);
    }
}
