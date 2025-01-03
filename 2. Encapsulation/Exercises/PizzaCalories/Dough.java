package Encapsulation.Exercises.PizzaCalories;

public class Dough
{
    private static final int CALORIES_PER_GRAM = 2;

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight)
    {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public void setFlourType(String flourType)
    {
        if(!(flourType.equals("White") || flourType.equals("Wholegrain")))
        {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique)
    {
        if(!(bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")))
        {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight)
    {
        if(weight < 1 || weight > 200)
        {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private double getFlourTypeModifier()
    {
        switch(flourType)
        {
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
            default:
                return 1.0;
        }
    }

    private double getBakingTechniqueModifier()
    {
        switch(bakingTechnique)
        {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
            default:
                return 1.0;
        }
    }

    public double calculateCalories()
    {
        return (CALORIES_PER_GRAM * weight) * getFlourTypeModifier() * getBakingTechniqueModifier();
    }
}
