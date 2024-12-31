package WorkingWithAbstraction.Exercises.CardsWithPowerSecondWay;

public class CardRank
{
    public static final String ACE = "ACE";
    public static final String TWO = "TWO";
    public static final String THREE = "THREE";
    public static final String FOUR = "FOUR";
    public static final String FIVE = "FIVE";
    public static final String SIX = "SIX";
    public static final String SEVEN = "SEVEN";
    public static final String EIGHT = "EIGHT";
    public static final String NINE = "NINE";
    public static final String TEN = "TEN";
    public static final String JACK = "JACK";
    public static final String QUEEN = "QUEEN";
    public static final String KING = "KING";

    public static int getRankPower(String rank)
    {
        switch(rank)
        {
            case ACE: return 14;
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case JACK: return 11;
            case QUEEN: return 12;
            case KING: return 13;
            default: throw new IllegalArgumentException("Invalid card rank: " + rank);
        }
    }
}
