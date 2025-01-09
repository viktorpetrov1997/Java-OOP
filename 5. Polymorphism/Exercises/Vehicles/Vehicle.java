package Polymorphism.Exercises.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle
{
    protected double fuelQuantity;
    protected double fuelConsumptionInLitersPerKm;

    public Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm)
    {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public String drive(double distance)
    {
        DecimalFormat df = new DecimalFormat("#.##");

        double requiredFuel = distance * fuelConsumptionInLitersPerKm;
        if(requiredFuel > fuelQuantity)
        {
            return getClass().getSimpleName() + " needs refueling";
        }
        fuelQuantity -= requiredFuel;
        return getClass().getSimpleName() + " travelled " + df.format(distance) + " km";
    }

    public abstract void refuel(double liters);

    public double getFuelQuantity()
    {
        return fuelQuantity;
    }
}
