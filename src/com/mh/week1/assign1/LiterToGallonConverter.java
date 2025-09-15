package com.mh.week1.assign1;

import java.util.Scanner;

/**
 * Class that converts liters to gallons
 */
public class LiterToGallonConverter {
    // Conversion constant: 1 liter = 0.264172 gallons
    private static final double LITER_TO_GALLON = 0.264172;

    /**
     * Converts liters to gallons
     * @param liters The volume in liters
     * @return The volume in gallons
     */
    public double convertLiterToGallon(double liters) {
        return liters * LITER_TO_GALLON;
    }

    /**
     * Method to run the liters to gallons converter
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Liters to Gallons Converter ===");
        System.out.print("Enter volume in liters: ");
        double liters = scanner.nextDouble();

        double gallons = convertLiterToGallon(liters);
        System.out.printf("%.2f liters = %.2f gallons%n", liters, gallons);
    }

    /**
     * Main method to run the converter directly
     */
    public static void main(String[] args) {
        new LiterToGallonConverter().run();
    }
}
