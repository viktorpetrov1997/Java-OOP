package Inheritance.Exercises.NeedForSpeed;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        SportCar sportCar = new SportCar(500, 300);

        sportCar.drive(25);

        System.out.println(sportCar.getFuel());
    }
}
