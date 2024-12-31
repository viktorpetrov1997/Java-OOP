package WorkingWithAbstraction.Exercises.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split(" ");

        List<TrafficLights> trafficLights = new ArrayList<>();
        for(String color : colors)
        {
            TrafficLights light = new TrafficLights(Color.valueOf(color));
            trafficLights.add(light);
        }

        int numberOfChanges = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfChanges; i++)
        {
            trafficLights.forEach(light ->
            {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            });
            System.out.println();
        }
    }
}
