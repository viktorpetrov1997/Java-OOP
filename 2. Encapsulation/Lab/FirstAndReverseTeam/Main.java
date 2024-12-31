package Encapsulation.Lab.FirstAndReverseTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main // This task must be submitted with a package called 'FirstAndReverseTeam'.
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfPeople; i++)
        {
            String[] personInfo = scanner.nextLine().split(" ");
            String firstName = personInfo[0];
            String lastName = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);
            double salary = Double.parseDouble(personInfo[3]);

            Person person = new Person(firstName, lastName, age, salary);
            people.add(person);
        }

        Team team = new Team("Black Eagles");

        for(Person person : people)
        {
            team.addPlayer(person);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
