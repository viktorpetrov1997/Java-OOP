package Polymorphism.Lab.WildFarm;

public class Zebra extends Mammal
{
    public Zebra(AnimalType type, String name, double weight, String livingRegion)
    {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound()
    {
        System.out.println("Zs");
    }

    @Override
    public boolean willEatFood(Food food)
    {
        return food instanceof Vegetable;
    }
}
