package Inheritance.Exercises.Animals;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while(!input.equals("Beast!"))
        {
            String animalType = input;
            String[] animalInfo = scanner.nextLine().split(" ");

            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            if(animalType.equals("Cat"))
            {
                try
                {
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat);
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else if(animalType.equals("Kitten"))
            {
                try
                {
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten);
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else if(animalType.equals("Tomcat"))
            {
                try
                {
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat);
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else if(animalType.equals("Dog"))
            {
                try
                {
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog);
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else if(animalType.equals("Frog"))
            {
                try
                {
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog);
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
            }

            input = scanner.nextLine();
        }
    }
}
