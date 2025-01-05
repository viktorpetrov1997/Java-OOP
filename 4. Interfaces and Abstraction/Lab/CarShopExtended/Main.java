package InterfacesAndAbstraction.Lab.CarShopExtended;

public class Main
{
    private static void printCarInfo(Car car)
    {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }

    public static void main(String[] args)
    {
        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);

        System.out.println("Audi price for 10 days: " + audi.getPriceForDays(10));
    }
}
