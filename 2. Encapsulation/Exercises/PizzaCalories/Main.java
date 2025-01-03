package Encapsulation.Exercises.PizzaCalories;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split(" ");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        String[] doughInfo = scanner.nextLine().split(" ");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double doughWeightInGrams = Double.parseDouble(doughInfo[3]);

        Dough dough = new Dough(flourType, bakingTechnique, doughWeightInGrams);
        pizza.setDough(dough);

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            String[] toppingInfo = input.split(" ");
            String toppingType = toppingInfo[1];
            double toppingWeightInGrams = Double.parseDouble(toppingInfo[2]);

            Topping topping = new Topping(toppingType, toppingWeightInGrams);
            pizza.addTopping(topping);

            input = scanner.nextLine();
        }

        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
    }
}
