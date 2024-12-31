package Encapsulation.Lab.SortByNameAndAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main // This task must be submitted with a package called 'SortByNameAndAge'.
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

            Person person = new Person(firstName, lastName, age);
            people.add(person);
        }

        people.sort((firstPerson, secondPerson) ->
        {
            int nameComparison = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if(nameComparison != 0)
            {
                return nameComparison;
            }
            else
            {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for(Person person : people)
        {
            System.out.println(person);
        }
    }
}
