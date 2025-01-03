package Encapsulation.Exercises.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza
{
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings)
    {
        setName(name);
        setToppings(numberOfToppings);
    }

    public void setName(String name)
    {
        if(name == null || name.trim().isEmpty() || name.length() > 15)
        {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough)
    {
        this.dough = dough;
    }

    public void setToppings(int numberOfToppings)
    {
        if(numberOfToppings < 0 || numberOfToppings > 10)
        {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public String getName()
    {
        return name;
    }

    public void addTopping(Topping topping)
    {
        if(toppings.size() < 10)
        {
            toppings.add(topping);
        }
    }

    public double getOverallCalories()
    {
        double doughCalories = dough.calculateCalories();

        double toppingCalories = 0;
        for(Topping topping : toppings)
        {
            toppingCalories += topping.calculateCalories();
        }

        return doughCalories + toppingCalories;
    }
}
