package SOLID.Exercises.CalorieCalculator;

import SOLID.Exercises.CalorieCalculator.products.Product;

import java.util.List;

public class CalorieCalculator
{
    public double sumCalories(List<Product> products)
    {
        return products.stream().mapToDouble(Product::getCalories).sum();
    }

    public double averageCalories(List<Product> products)
    {
        return sumCalories(products) / products.size();
    }
}
