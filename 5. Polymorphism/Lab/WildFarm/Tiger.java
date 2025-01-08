package Polymorphism.Lab.WildFarm;

public class Tiger extends Feline
{
    public Tiger(AnimalType type, String name, double weight, String livingRegion)
    {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound()
    {
        System.out.println("ROAAR!!!");
    }

    @Override
    public boolean willEatFood(Food food)
    {
        return food instanceof Meat;
    }
}
