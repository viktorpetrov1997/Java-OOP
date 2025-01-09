package Polymorphism.Exercises.Vehicles;

public class Car extends Vehicle
{
    private static final double SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm)
    {
        super(fuelQuantity, fuelConsumptionInLitersPerKm + SUMMER_CONSUMPTION);
    }

    @Override
    public void refuel(double liters)
    {
        fuelQuantity += liters;
    }
}
