package SOLID.Exercises.CalorieCalculator;

import SOLID.Exercises.CalorieCalculator.products.Food;
import SOLID.Exercises.CalorieCalculator.products.Drink;

import java.util.List;

public class QuantityCalculator
{
    public double sumKilograms(List<Food> foods)
    {
        return foods.stream().mapToDouble(Food::getKilograms).sum();
    }

    public double sumLiters(List<Drink> drinks)
    {
        return drinks.stream().mapToDouble(Drink::getLiters).sum();
    }
}
