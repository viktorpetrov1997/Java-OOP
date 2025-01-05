package InterfacesAndAbstraction.Lab.CarShopExtended;

public interface Rentable extends Car
{
    Integer getMinRentDay();

    Double getPricePerDay();

    default Double getPriceForDays(int numberOfDays)
    {
        if(numberOfDays < getMinRentDay())
        {
            String message = String.format("Cannot rent %s for less than %d days", getModel(), getMinRentDay());
            throw new IllegalArgumentException(message);
        }
        return numberOfDays * getPricePerDay();
    }
}
