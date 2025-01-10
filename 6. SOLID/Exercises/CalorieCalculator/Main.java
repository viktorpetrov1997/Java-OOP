package SOLID.Exercises.CalorieCalculator;

import SOLID.Exercises.CalorieCalculator.products.*;

import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Product> products = Arrays.asList(
                new Chocolate(200),
                new Coke(500),
                new Lemonade(300),
                new Chips(150)
        );

        List<Food> foods = Arrays.asList(
                new Chocolate(200),
                new Chips(150)
        );

        List<Drink> drinks = Arrays.asList(
                new Coke(500),
                new Lemonade(300)
        );

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        QuantityCalculator quantityCalculator = new QuantityCalculator();
        Printer printer = new Printer();

        printer.printCalories(calorieCalculator, "Total Calories", products);
        printer.printAverageCalories(calorieCalculator, products);
        printer.printQuantities(quantityCalculator, foods, drinks);
    }
}