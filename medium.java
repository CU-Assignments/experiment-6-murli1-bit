import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class medium {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Guri", 85),
            new Student("Murli", 95),
            new Student("Jai", 90),
            new Student("Sargun", 80),
            new Student("Birla", 88)
        );

        List<String> filteredSortedStudents = students.stream()
            .filter(student -> student.getMarks() > 75)
            .sorted((s1, s2) -> Integer.compare(s2.getMarks(), s1.getMarks()))
            .map(Student::getName)
            .collect(Collectors.toList());

        filteredSortedStudents.forEach(System.out::println);
    }
}

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}
