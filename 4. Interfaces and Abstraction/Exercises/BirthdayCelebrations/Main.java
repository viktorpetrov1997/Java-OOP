package InterfacesAndAbstraction.Exercises.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String[] inputData = input.split(" ");

            String entity = inputData[0];
            if(entity.equals("Citizen"))
            {
                String name = inputData[1];
                int age = Integer.parseInt(inputData[2]);
                String id = inputData[3];
                String birthDate = inputData[4];
                birthables.add(new Citizen(name, age, id, birthDate));
            }
            else if(entity.equals("Pet"))
            {
                String name = inputData[1];
                String birthDate = inputData[2];
                birthables.add(new Pet(name, birthDate));
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for(Birthable birthable : birthables)
        {
            if(birthable.getBirthDate().endsWith(year))
            {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
