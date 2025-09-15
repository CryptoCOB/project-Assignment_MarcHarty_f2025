package com.mh.week1.assign1;

import java.util.Scanner;

/**
 * Class that calculates grades for courses
 */
public class GradeCalculator {

    /**
     * Calculates the letter grade based on the numeric grade
     * @param score The numeric score (0-100)
     * @return The letter grade (A, B, C, D, or F)
     */
    public String calculateGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }

        if (score >= 97) {
            return "A+";
        } else if (score >= 93) {
            return "A";
        } else if (score >= 90) {
            return "A-";
        } else if (score >= 87) {
            return "B+";
        } else if (score >= 83) {
            return "B";
        } else if (score >= 80) {
            return "B-";
        } else if (score >= 77) {
            return "C+";
        } else if (score >= 73) {
            return "C";
        } else if (score >= 70) {
            return "C-";
        } else if (score >= 67) {
            return "D+";
        } else if (score >= 63) {
            return "D";
        } else if (score >= 60) {
            return "D-";
        } else {
            return "F";
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Grade Calculator ===");
        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();

        for (int i = 1; i <= numCourses; i++) {
            System.out.print("Enter the name of course " + i + ": ");
            scanner.nextLine(); // Consume newline
            String courseName = scanner.nextLine();

            System.out.print("Enter the score for " + courseName + " (0-100): ");
            double score = scanner.nextDouble();

            String grade = calculateGrade(score);
            System.out.println("Grade for " + courseName + ": " + grade);
        }
    }

    /**
     * Main method to run the grade calculator directly
     */
    public static void main(String[] args) {
        new GradeCalculator().run();
    }
}
