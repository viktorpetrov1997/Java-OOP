package Polymorphism.Lab.WildFarm;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class Mammal extends Animal
{
    private String livingRegion;

    public Mammal(AnimalType type, String name, double weight, String livingRegion)
    {
        super(type, name, weight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion()
    {
        return livingRegion;
    }

    @Override
    public String toString()
    {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("###.##", symbols);

        String formattedWeight = decimalFormat.format(this.getWeight());

        return String.format("%s[%s, %s, %s, %d]", getType(), getName(), formattedWeight,
                livingRegion, getFoodEaten());
    }
}
