package Lab9.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Creating sample students
        Student student1 = new Student("1", "Alice", 2021);
        Student student2 = new Student("2", "Cynthia", 2022);
        Student student3 = new Student("3", "Saga", 2021);
        Student student4 = new Student("4", "Casey", 2023);

        // Creating sample courses
        List<Student> students1 = new ArrayList<>(Arrays.asList(student1, student2));
        List<Student> students2 = new ArrayList<>(Arrays.asList(student3, student4));
        Course course1 = new Course("1", "Math", "Theory", students1, "Dr. Smith");
        Course course2 = new Course("2", "Physics", "Pratice", students2, "Dr. Johnson");

        // tạo faculty
        List<Course> courses = new ArrayList<>(Arrays.asList(course1, course2));
        Faculty faculty = new Faculty("Science Faculty", "123 Faculty St", courses);
        faculty.setCourses(Arrays.asList(course1, course2));
        // Testing getMaxPraticalCourse method
        Course maxPracticalCourse = faculty.getMaxPraticalCourse();
        System.out.println("Max Practical Course: " + maxPracticalCourse.getTitle());

        // Testing groupStudentsByYear method
        Map<Integer, List<Student>> studentsByYear = faculty.groupStudentsByYear();
        for (Map.Entry<Integer, List<Student>> entry : studentsByYear.entrySet()) {
            System.out.println("Students in year " + entry.getKey() + ":");
            for (Student student : entry.getValue()) {
                System.out.println("- " + student.getName());
            }
        }
        // Testing filterCourses method
        Set<Course> filteredCourses = faculty.filterCourses("Pratice");
        System.out.println("Filtered Courses:");
        for (Course course : filteredCourses) {
            System.out.println("- " + course.getTitle());
        }
    }
}
