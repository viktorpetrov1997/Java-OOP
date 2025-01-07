package InterfacesAndAbstraction.Exercises.FoodShortage;

import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Buyer> buyers = new HashMap<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numberOfPeople; i++)
        {
            String[] inputData = scanner.nextLine().split(" ");

            if(inputData.length == 4)
            {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                String birthDate = inputData[3];
                buyers.put(name, new Citizen(name, age, id, birthDate));
            }
            else if(inputData.length == 3)
            {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String group = inputData[2];
                buyers.put(name, new Rebel(name, age, group));
            }
        }

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String name = input;

            if(buyers.containsKey(name))
            {
                buyers.get(name).buyFood();
            }

            input = scanner.nextLine();
        }

        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
