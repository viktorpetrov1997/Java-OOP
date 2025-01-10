package SOLID.Exercises.CalorieCalculator;

import SOLID.Exercises.CalorieCalculator.products.Drink;
import SOLID.Exercises.CalorieCalculator.products.Food;
import SOLID.Exercises.CalorieCalculator.products.Product;

import java.util.List;

public class Printer
{
    public void print(String message)
    {
        System.out.println(message);
    }

    public void printCalories(CalorieCalculator calculator, String label, List<Product> products)
    {
        System.out.printf("%s: %.2f%n", label, calculator.sumCalories(products));
    }

    public void printAverageCalories(CalorieCalculator calculator, List<Product> products)
    {
        System.out.printf("Average: %.2f%n", calculator.averageCalories(products));
    }

    public void printQuantities(QuantityCalculator calculator, List<Food> foods, List<Drink> drinks)
    {
        System.out.printf("Total Kilograms: %.2f%n", calculator.sumKilograms(foods));
        System.out.printf("Total Liters: %.2f%n", calculator.sumLiters(drinks));
    }
}