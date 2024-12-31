package WorkingWithAbstraction.Exercises.CardsWithPowerSecondWay;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        int rankPower = CardRank.getRankPower(cardRank);
        int suitPower = CardSuit.getSuitPower(cardSuit);

        Card card = new Card(cardRank, rankPower, cardSuit, suitPower);
        System.out.println(card);
    }
}
