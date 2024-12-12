package com.app.codes.hackerrank;

import java.util.Scanner;

public class GradingStudents {

    public static int[] gradingStudents(int[] grades) {
        int[] roundedGrades = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];

            if (grade < 38) {
                // Grade less than 38 is failing, no rounding needed
                roundedGrades[i] = grade;
            } else {
                // Calculate the next multiple of 5
                int nextMultipleOf5 = (int) Math.ceil(grade / 5.0) * 5;

                // Check if rounding is needed
                if (nextMultipleOf5 - grade < 3) {
                    roundedGrades[i] = nextMultipleOf5;
                } else {
                    // No rounding needed
                    roundedGrades[i] = grade;
                }
            }
        }

        return roundedGrades;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] grades = new int[n];

        System.out.println("Enter the grades of students:");
        for (int i = 0; i < n; i++) {
            grades[i] = scanner.nextInt();
        }

        int[] result = gradingStudents(grades);
        System.out.println("Rounded grades:");
        for (int grade : result) {
            System.out.println(grade);
        }

        scanner.close();
    }
}
