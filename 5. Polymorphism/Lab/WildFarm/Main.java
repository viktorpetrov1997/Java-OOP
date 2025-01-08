package Polymorphism.Lab.WildFarm;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String[] inputData = input.split(" ");

            AnimalType type = AnimalType.valueOf(inputData[0]);
            String name = inputData[1];
            double weight = Double.parseDouble(inputData[2]);
            String livingRegion = inputData[3];

            Animal animal = null;

            if(type == AnimalType.Cat)
            {
                String breed = inputData[4];
                animal = new Cat(type, name, weight, livingRegion, breed);
            }
            else if(type == AnimalType.Tiger)
            {
                animal = new Tiger(type, name, weight, livingRegion);
            }
            else if(type == AnimalType.Mouse)
            {
                animal = new Mouse(type, name, weight, livingRegion);
            }
            else if(type == AnimalType.Zebra)
            {
                animal = new Zebra(type, name, weight, livingRegion);
            }

            animal.makeSound();

            String[] foodInfo = scanner.nextLine().split(" ");
            FoodType foodType = FoodType.valueOf(foodInfo[0]);
            int foodQuantity = Integer.parseInt(foodInfo[1]);

            Food food = null;

            if(foodType == FoodType.Meat)
            {
                food = new Meat(foodQuantity);
            }
            else if(foodType == FoodType.Vegetable)
            {
                food = new Vegetable(foodQuantity);
            }

            animal.eat(food);

            System.out.println(animal);

            input = scanner.nextLine();
        }
    }
}
