package Polymorphism.Exercises.VehiclesExtension;

public class Truck extends Vehicle
{
    private static final double SUMMER_CONSUMPTION = 1.6;
    private static final double REFUEL_EFFICIENCY = 0.95;

    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity)
    {
        super(fuelQuantity, fuelConsumptionInLitersPerKm + SUMMER_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double liters)
    {
        super.refuel(liters * REFUEL_EFFICIENCY);
    }
}
