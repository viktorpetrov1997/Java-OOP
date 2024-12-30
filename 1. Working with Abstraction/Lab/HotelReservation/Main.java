package WorkingWithAbstraction.Lab.HotelReservation;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        double pricePerDay = Double.parseDouble(parts[0]);
        int numberOfDays = Integer.parseInt(parts[1]);
        PriceCalculator.Season season = PriceCalculator.Season.valueOf(parts[2]);
        PriceCalculator.DiscountType discountType = PriceCalculator.DiscountType.valueOf(parts[3]);

        double totalPrice = PriceCalculator.calculateTotalPrice(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f%n", totalPrice);
    }
}
