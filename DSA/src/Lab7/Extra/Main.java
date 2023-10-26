package Lab7.Extra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Clazz clazz = new Clazz("Sample Class", "2023");

        try {
            clazz.loadStudents("students.txt");

            // Display all students
            System.out.println("All Students:");
            clazz.display();

            // Sort students by GPA
            System.out.println("\nStudents sorted by GPA:");
            clazz.sortStudents(Comparator.comparingDouble(Student::getGPA).reversed());
            clazz.display();

            // Get and display the top 3 students by GPA
            System.out.println("\nTop 3 Students by GPA:");
            ArrayList<Student> topStudents = clazz.getTopNStudents(3);
            for (Student student : topStudents) {
                System.out.println(student);
            }

            // Get and display 5 random students
            System.out.println("\nRandom 5 Students:");
            ArrayList<Student> randomStudents = clazz.getRandomNStudents(5);
            for (Student student : randomStudents) {
                System.out.println(student);
            }

            // Remove a student by ID
            String idToRemove = "18130006";
            boolean removed = clazz.removeStudent(idToRemove);
            System.out.println("\nRemoved Student with ID " + idToRemove + ": " + removed+"\n");
            clazz.display();
            // Get and display students born in 1998
            System.out.println("\nStudents Born in 1998:");
            ArrayList<Student> students1998 = clazz.getStudentByBirthYear(1998);
            for (Student student : students1998) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading students: " + e.getMessage());
        }
    }
}
