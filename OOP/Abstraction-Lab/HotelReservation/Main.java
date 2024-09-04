package class11.lab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());
        Discount discount = Discount.getDiscount(tokens[3]);
        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, season, discount);
        System.out.printf("%.2f%n", priceCalculator.CalculatePrice());
    }
}
