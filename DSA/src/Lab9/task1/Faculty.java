package Lab9.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
    private String name;
    private String address;
    private List<Course> courses;

    public Faculty(String name, String address, List<Course> courses) {
        super();
        this.name = name;
        this.address = address;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course getMaxPraticalCourse() {
        Course maxCourse = null;
        int maxStudents = -1; // Số sinh viên đăng ký lớn nhất, ban đầu đặt là -1

        for (Course course : courses) {
            if (course.isPraticeCourse() && course.getStudents().size() > maxStudents) {
                maxStudents = course.getStudents().size();
                maxCourse = course;
            }
        }
        return maxCourse;
    }

    public Map<Integer, List<Student>> groupStudentsByYear() {
        Map<Integer, List<Student>> map = new HashMap<>();
        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                map.putIfAbsent(student.getYear(), new ArrayList<>());
                map.get(student.getYear()).add(student);
            }
        }
        return map;
    }

    public Set<Course> filterCourses(String type) {
        TreeSet<Course> set = new TreeSet<Course>(new Comparator<Course>() {

            @Override
            public int compare(Course o1, Course o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o2.students.size(), o1.students.size());
            }
        });
        for (Course course : courses) {
            if (course.getType().equals(type)) {
                set.add(course);
            }
        }
        return set;
    }

}
