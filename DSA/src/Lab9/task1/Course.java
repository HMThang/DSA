package Lab9.task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {
    private String id;
    private String title;
    private String type;
    List<Student> students;
    private String lecturer;

    public Course(String id, String title, String type, List<Student> students, String lecturer) {
        super();
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = students;
        this.lecturer = lecturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public boolean hasMoreStudentsThan(Course course) {
        return this.getStudents().size() > course.getStudents().size();
    }

    public boolean isPraticeCourse() {
        return this.type.equals("Pratice");
    }

}
