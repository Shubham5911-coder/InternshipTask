package Internship;

import java.util.Scanner;

class Student {
    private int totalMarks;
    private int numOfSubjects;
    private double averagePercentage;
    private char grade;

    public Student() {
        totalMarks = 0;
        numOfSubjects = 0;
        averagePercentage = 0.0;
        grade = ' ';
    }

    public void inputMarks() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        numOfSubjects = scanner.nextInt();

        for (int i = 1; i <= numOfSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        scanner.close();
    }

    public void calculate() {
        averagePercentage = (double) totalMarks / numOfSubjects;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public void display() {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Student student = new Student();
        student.inputMarks();
        student.calculate();
        student.display();
    }
}
