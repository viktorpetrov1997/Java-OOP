package Encapsulation.Lab.SalaryIncrease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main // This task must be submitted with a package called 'SalaryIncrease'.
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

        double bonus = Double.parseDouble(scanner.nextLine());

        for(Person person : people)
        {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}
