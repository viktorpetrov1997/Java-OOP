package Encapsulation.Exercises.AnimalFarm;

import java.util.Scanner;

public class Main // This task must be submitted with a package called 'AnimalFarm'.
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Chicken chicken = new Chicken(name, age);
        System.out.println(chicken);
    }
}
