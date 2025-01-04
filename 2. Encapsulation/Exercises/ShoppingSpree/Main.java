package Encapsulation.Exercises.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main // This task must be submitted with a package called 'ShoppingSpree'.
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        String[] personInput = scanner.nextLine().split(";");
        for(String personData : personInput)
        {
            String[] personInfo = personData.split("=");
            String name = personInfo[0];
            double money = Double.parseDouble(personInfo[1]);

            people.putIfAbsent(name, new Person(name, money));
        }

        String[] productInput = scanner.nextLine().split(";");
        for(String productData : productInput)
        {
            String[] productInfo = productData.split("=");
            String name = productInfo[0];
            double cost = Double.parseDouble(productInfo[1]);

            products.putIfAbsent(name, new Product(name, cost));
        }

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            String[] purchaseData = input.split(" ");
            String personName = purchaseData[0];
            String productName = purchaseData[1];

            if(people.containsKey(personName) && products.containsKey(productName))
            {
                Person person = people.get(personName);
                Product product = products.get(productName);

                person.buyProduct(product);
            }

            input = scanner.nextLine();
        }

        for(Person person : people.values())
        {
            System.out.println(person);
        }
    }
}
