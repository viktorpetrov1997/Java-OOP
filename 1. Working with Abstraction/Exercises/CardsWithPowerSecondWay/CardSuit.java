package WorkingWithAbstraction.Exercises.CardsWithPowerSecondWay;

public class CardSuit
{
    public static final String CLUBS = "CLUBS";
    public static final String DIAMONDS = "DIAMONDS";
    public static final String HEARTS = "HEARTS";
    public static final String SPADES = "SPADES";

    public static int getSuitPower(String suit)
    {
        switch(suit)
        {
            case CLUBS: return 0;
            case DIAMONDS: return 13;
            case HEARTS: return 26;
            case SPADES: return 39;
            default: throw new IllegalArgumentException("Invalid card suit: " + suit);
        }
    }
}
