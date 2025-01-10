package SOLID.Exercises.CalorieCalculator.products;

public class Chocolate implements Product, Food
{
    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private double grams;

    public Chocolate(double grams)
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
