package InterfacesAndAbstraction.Lab.CarShopExtended;

public class Audi extends CarImpl implements Rentable
{
    private Integer minRentDays;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDays, Double pricePerDay)
    {
        super(model, color, horsePower, countryProduced);
        this.minRentDays = minRentDays;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Double getPricePerDay()
    {
        return pricePerDay;
    }

    @Override
    public Integer getMinRentDay()
    {
        return minRentDays;
    }

    @Override
    public String toString()
    {
        return String.format("%s\nMinimum rental period of %d days. Price per day %f",
                super.toString(), minRentDays, pricePerDay);
    }
}
