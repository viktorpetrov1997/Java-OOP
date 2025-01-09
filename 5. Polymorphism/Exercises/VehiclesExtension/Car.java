package Polymorphism.Exercises.VehiclesExtension;

public class Car extends Vehicle
{
    private static final double SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity)
    {
        super(fuelQuantity, fuelConsumptionInLitersPerKm + SUMMER_CONSUMPTION, tankCapacity);
    }
}
