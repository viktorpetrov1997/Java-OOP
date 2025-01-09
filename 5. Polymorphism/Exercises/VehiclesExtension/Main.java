package Polymorphism.Exercises.VehiclesExtension;

import java.util.Scanner;

public class Main
{
    private static Vehicle createVehicle(String input)
    {
        String[] vehicleInfo = input.split(" ");
        String type = vehicleInfo[0];
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumption = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);

        switch(type)
        {
            case "Car": return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck": return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus": return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
            default: throw new IllegalArgumentException("Invalid vehicle type");
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = createVehicle(scanner.nextLine());
        Vehicle truck = createVehicle(scanner.nextLine());
        Bus bus = (Bus) createVehicle(scanner.nextLine());

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numberOfCommands; i++)
        {
            String[] commandParts = scanner.nextLine().split(" ");

            String command = commandParts[0];
            String vehicle = commandParts[1];

            if(command.equals("Drive"))
            {
                double distance = Double.parseDouble(commandParts[2]);
                if(vehicle.equals("Car"))
                {
                    System.out.println(car.drive(distance));
                }
                else if(vehicle.equals("Truck"))
                {
                    System.out.println(truck.drive(distance));
                }
                else if(vehicle.equals("Bus"))
                {
                    System.out.println(bus.driveWithPeople(distance));
                }
            }
            else if(command.equals("DriveEmpty"))
            {
                double distance = Double.parseDouble(commandParts[2]);
                if(vehicle.equals("Bus"))
                {
                    System.out.println(bus.drive(distance));
                }
            }
            else if(command.equals("Refuel"))
            {
                double liters = Double.parseDouble(commandParts[2]);
                if(vehicle.equals("Car"))
                {
                    car.refuel(liters);
                }
                else if(vehicle.equals("Truck"))
                {
                    truck.refuel(liters);
                }
                else if(vehicle.equals("Bus"))
                {
                    bus.refuel(liters);
                }
            }
        }

        System.out.printf("Car: %.2f\n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f", bus.getFuelQuantity());
    }
}
