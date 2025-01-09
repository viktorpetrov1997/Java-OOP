package Polymorphism.Exercises.Vehicles;

public class Truck extends Vehicle
{
    private static final double SUMMER_CONSUMPTION = 1.6;
    private static final double REFUEL_EFFICIENCY = 0.95;

    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm)
    {
        super(fuelQuantity, fuelConsumptionInLitersPerKm + SUMMER_CONSUMPTION);
    }

    @Override
    public void refuel(double liters)
    {
        fuelQuantity += liters * REFUEL_EFFICIENCY;
    }
}
