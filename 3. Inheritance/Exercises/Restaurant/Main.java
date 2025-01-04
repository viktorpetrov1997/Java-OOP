package Inheritance.Exercises.Restaurant;

import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args)
    {
        BigDecimal salmonPrice = BigDecimal.valueOf(14.99);

        Salmon salmon = new Salmon("Salmon", salmonPrice);

        System.out.println("Name: " + salmon.getName());
        System.out.println("Price: " + salmon.getPrice());
        System.out.println("Grams: " + salmon.getGrams());
    }
}
