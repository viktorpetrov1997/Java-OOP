package SOLID.Exercises.CalorieCalculator.products;

public class Chips implements Product, Food
{
    private static final double CALORIES_PER_100_GRAMS = 529.0;
    private final double grams;

    public Chips(double grams)
    {
        this.grams = grams;
    }

    @Override
    public double getKilograms()
    {
        return grams / 1000;
    }

    @Override
    public double getCalories()
    {
        return (CALORIES_PER_100_GRAMS / 100) * grams;
    }
}
