package com.mh.week1.assign1;

import java.util.Scanner;

/**
 * Main driver class for Assignment 1
 * Assignment1_MarcHarty_F2025
 */
public class Assignment1Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Assignment 1 - Marc Harty F2025");
        System.out.println("==============================================");

        while (!exit) {
            // Display menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. Calculate Grades");
            System.out.println("2. Convert Miles to Kilometers");
            System.out.println("3. Convert Liters to Gallons");
            System.out.println("4. Convert CAD to USD");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create GradeCalculator object and call its run method
                    GradeCalculator gradeCalculator = new GradeCalculator();
                    gradeCalculator.run();
                    break;

                case 2:
                    // Create MileToKilometerConverter object and call its run method
                    MileToKilometerConverter mileConverter = new MileToKilometerConverter();
                    mileConverter.run();
                    break;

                case 3:
                    // Create LiterToGallonConverter object and call its run method
                    LiterToGallonConverter literConverter = new LiterToGallonConverter();
                    literConverter.run();
                    break;

                case 4:
                    // Create CurrencyConverter object and call its run method
                    CurrencyConverter currencyConverter = new CurrencyConverter();
                    currencyConverter.run();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thank you for using the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
