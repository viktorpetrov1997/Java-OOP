package Polymorphism.Lab.WildFarm;

public class Mouse extends Mammal
{
    public Mouse(AnimalType type, String name, double weight, String livingRegion)
    {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound()
    {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public boolean willEatFood(Food food)
    {
        return food instanceof Vegetable;
    }
}
