package Polymorphism.Exercises.VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle
{
    protected double fuelQuantity;
    protected double fuelConsumptionInLitersPerKm;
    protected double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity)
    {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.tankCapacity = tankCapacity;
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

    public void refuel(double liters)
    {
        if(liters <= 0)
        {
            System.out.println("Fuel must be a positive number");
            return;
        }

        if(fuelQuantity + liters > tankCapacity)
        {
            System.out.println("Cannot fit fuel in tank");
            return;
        }

        fuelQuantity += liters;
    }

    public double getFuelQuantity()
    {
        return fuelQuantity;
    }
}
