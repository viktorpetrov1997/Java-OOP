package Inheritance.Exercises.NeedForSpeed;

public class Vehicle
{
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower)
    {
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    public void setFuelConsumption(double fuelConsumption)
    {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel)
    {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower)
    {
        this.horsePower = horsePower;
    }

    public double getFuelConsumption()
    {
        return fuelConsumption;
    }

    public double getFuel()
    {
        return fuel;
    }

    public int getHorsePower()
    {
        return horsePower;
    }

    public void drive(double kilometers)
    {
        double neededFuel = kilometers * fuelConsumption;
        if(fuel >= neededFuel)
        {
            fuel -= neededFuel;
        }
        else
        {
            System.out.println("Not enough fuel to perform this trip.");
        }
    }
}
