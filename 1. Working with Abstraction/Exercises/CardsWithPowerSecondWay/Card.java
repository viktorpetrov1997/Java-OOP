package WorkingWithAbstraction.Exercises.CardsWithPowerSecondWay;

public class Card
{
    private String rank;
    private String suit;
    private int rankPower;
    private int suitPower;

    public Card(String rank, int rankPower, String suit, int suitPower)
    {
        this.rank = rank;
        this.rankPower = rankPower;
        this.suit = suit;
        this.suitPower = suitPower;
    }

    public int getPower()
    {
        return this.rankPower + this.suitPower;
    }

    @Override
    public String toString()
    {
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit, this.getPower());
    }
}
