package WorkingWithAbstraction.Lab.HotelReservation;

public class PriceCalculator
{
    enum Season
    {
        Spring(2), Summer(4), Autumn(1), Winter(3);

        private final int multiplier;

        Season(int multiplier)
        {
            this.multiplier = multiplier;
        }

        public int getMultiplier()
        {
            return this.multiplier;
        }
    }

    enum DiscountType
    {
        VIP(0.20), SecondVisit(0.10), None(0.0);

        private final double discountRate;

        DiscountType(double discountRate)
        {
            this.discountRate = discountRate;
        }

        public double getDiscountRate()
        {
            return this.discountRate;
        }
    }

    public static double calculateTotalPrice(double pricePerDay, int numberOfDays, Season season, DiscountType discountType)
    {
        double basePrice = pricePerDay * numberOfDays * season.getMultiplier();
        double discount = basePrice * discountType.getDiscountRate();
        return basePrice - discount;
    }
}
