package Encapsulation.Exercises.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person
{
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money)
    {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name)
    {
        if(name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money)
    {
        if(money < 0)
        {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product)
    {
        if(money >= product.getCost())
        {
            products.add(product);
            money -= product.getCost();
            System.out.println(name + " bought " + product.getName());
        }
        else
        {
            throw new IllegalArgumentException(String.format("%s can't afford %s", name, product.getName()));
        }
    }

    @Override
    public String toString()
    {
        if(products.isEmpty())
        {
            return name + " - Nothing bought";
        }
        else
        {
            return name + " - " + String.join(", ", products.stream().map(Product::getName).collect(Collectors.toList()));

            /*
            StringBuilder productNames = new StringBuilder();

            for(int i = 0; i < products.size(); i++)
            {
                productNames.append(products.get(i).getName());
                if(i < products.size() - 1)
                {
                    productNames.append(", ");
                }

            }

            return name + " - " + productNames;
            */ // Another way to print the products
        }
    }
}
