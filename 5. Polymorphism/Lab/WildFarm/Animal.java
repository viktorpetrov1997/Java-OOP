package Polymorphism.Lab.WildFarm;

public abstract class Animal
{
    private AnimalType type;
    private String name;
    private double weight;
    private int foodEaten;

    public Animal(AnimalType type, String name, double weight)
    {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public AnimalType getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public double getWeight()
    {
        return weight;
    }

    public int getFoodEaten()
    {
        return foodEaten;
    }

    public abstract void makeSound();

    public abstract boolean willEatFood(Food food);

    public void eat(Food food)
    {
        if(!willEatFood(food))
        {
            System.out.printf("%ss are not eating that type of food!\n", type.name());
            return;
        }
        foodEaten += food.getQuantity();
    }
}