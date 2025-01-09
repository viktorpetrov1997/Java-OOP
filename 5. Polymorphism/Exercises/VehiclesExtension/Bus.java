package Polymorphism.Exercises.VehiclesExtension;

public class Bus extends Vehicle
{
    public Bus(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity)
    {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    public String driveWithPeople(double distance)
    {
        fuelConsumptionInLitersPerKm += 1.4;
        String result = super.drive(distance);
        fuelConsumptionInLitersPerKm -= 1.4;
        return result;
    }
}
