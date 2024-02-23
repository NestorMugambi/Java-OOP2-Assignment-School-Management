package com.example.management;
import com.example.management.Student;
import java.util.Scanner;



public class StudentGradesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Math grade: ");
            double mathGrade = scanner.nextDouble();
            System.out.print("English grade: ");
            double englishGrade = scanner.nextDouble();
            System.out.print("Science grade: ");
            double scienceGrade = scanner.nextDouble();


            students[i] = new Student(name, mathGrade, englishGrade, scienceGrade);

        }


        System.out.println("\nStudent Grades Report:");
        for (Student student : students) {
            System.out.println(student.getName() + " - Total marks: " + student.CalculateTotal() + " - Average Marks: " + student.calculateAverage());

        }
    }

}

