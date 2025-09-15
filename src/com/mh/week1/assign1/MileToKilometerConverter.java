package com.mh.week1.assign1;

import java.util.Scanner;

/**
 * Class that converts miles to kilometers
 */
public class MileToKilometerConverter {
    // Conversion constant: 1 mile = 1.60934 kilometers
    private static final double MILE_TO_KM = 1.60934;

    /**
     * Converts miles to kilometers
     * @param miles The distance in miles
     * @return The distance in kilometers
     */
    public double convertMileToKm(double miles) {
        return miles * MILE_TO_KM;
    }

    /**
     * Method to run the miles to kilometers converter
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Miles to Kilometers Converter ===");
        System.out.print("Enter distance in miles: ");
        double miles = scanner.nextDouble();

        double kilometers = convertMileToKm(miles);
        System.out.printf("%.2f miles = %.2f kilometers%n", miles, kilometers);
    }

    /**
     * Main method to run the converter directly
     */
    public static void main(String[] args) {
        new MileToKilometerConverter().run();
    }
}
