package Lab7.Extra;

import java.io.*;
import java.util.*;

public class Clazz {
    private String name;
    private String year;// 2017, 2018, 2019, ...
    private ArrayList<Student> students = new ArrayList<Student>();

    public Clazz(String name, String year) {
        this.name = name;
        this.year = year;
    }

    public void loadStudents(String fileName) throws IOException {
        // phần này e lấy path là Lab6\\Extra\\students.txt bị lỗi The system cannot find the file specified nên phải để đường dẫn dài ạ
        File file = new File("C:\\Users\\huynh\\OneDrive\\Desktop\\WorkSpace\\DSA\\src\\Lab7\\Extra\\students.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while (true) {
            line = reader.readLine();
            if (line == null)
                break;
            StringTokenizer tokens = new StringTokenizer(line, "\t");
            String id = tokens.nextToken();
            String firstName = tokens.nextToken();
            String lastName = tokens.nextToken();
            int birthYear = Integer.parseInt(tokens.nextToken());
            double GPA = Double.parseDouble(tokens.nextToken());
            students.add(new Student(id, firstName, lastName, birthYear, GPA));
        }
        reader.close();
    }

    // sort students according to the given comparator c
    public void sortStudents(Comparator<Student> c) {
        Student[] array = students.toArray(new Student[students.size()]);
        Arrays.sort(array, c);
        for (int i = 0; i < array.length; i++) {
            students.set(i, array[i]);
        }
    }

    // get top n students with highest GPA
    public ArrayList<Student> getTopNStudents(int n) {
        ArrayList<Student> listStudent = new ArrayList<>();
        Comparator<Student> c = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getGPA(), o2.getGPA());
            }
        };
        sortStudents(c);
        for (int i = 0; i < n; i++) {
            listStudent.add(students.get(students.size() - i - 1));
        }
        return listStudent;
    }

    // get random n students from the list of students
    public ArrayList<Student> getRandomNStudents(int n) {
        ArrayList<Student> listStudent = new ArrayList<>();
        Collections.shuffle(students);
        for (int i = 0; i < n; i++) {
            listStudent.add(students.get(i));
        }
        return listStudent;
    }

    // remove a student with a given id
    public boolean removeStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (id.equals(students.get(i).getId())) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    // get all students who were born in a given birth year.
    public ArrayList<Student> getStudentByBirthYear(int birthYear) {
        ArrayList<Student> listStudent = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (birthYear == students.get(i).getBirthYear()) {
                listStudent.add(students.get(i));
            }
        }
        return listStudent;
    }

    // similar as toString method, this method prints the name, year, and all
    // students of the class. Note that, using iterator
    public void display() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i) + "\n");
        }
    }
}
