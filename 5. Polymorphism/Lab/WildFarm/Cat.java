package Polymorphism.Lab.WildFarm;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Cat extends Feline
{
    private String breed;

    public Cat(AnimalType type, String name, double weight, String livingRegion, String breed)
    {
        super(type, name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound()
    {
        System.out.println("Meowwww");
    }

    @Override
    public boolean willEatFood(Food food)
    {
        return true;
    }

    @Override
    public String toString()
    {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("###.##", symbols);

        return String.format("%s[%s, %s, %s, %s, %d]", getType(), getName(), breed,
                decimalFormat.format(getWeight()), getLivingRegion(), getFoodEaten());
    }
}
