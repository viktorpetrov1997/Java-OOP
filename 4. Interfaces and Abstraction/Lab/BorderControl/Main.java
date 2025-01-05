package InterfacesAndAbstraction.Lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> inhabitants = new ArrayList<>();

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String[] inputData = input.split(" ");

            Identifiable next;

            if(inputData.length == 2)
            {
                next = new Robot(inputData[1], inputData[0]);
            }
            else
            {
                next = new Citizen(inputData[0], Integer.parseInt(inputData[1]), inputData[2]);
            }

            inhabitants.add(next);

            input = scanner.nextLine();
        }

        String lastDigitsOfFakeIds = scanner.nextLine();

        inhabitants.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(lastDigitsOfFakeIds))
                .forEach(System.out::println);
    }
}
