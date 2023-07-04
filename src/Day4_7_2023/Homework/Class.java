package Day4_7_2023.Homework;

import java.util.HashSet;
import java.util.Set;

public class Class {

    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();
        Student studentA = new Student(16, "A");
        Student studentB = new Student(17, "A");
        System.out.println(studentA.hashCode());
        System.out.println(studentB.hashCode());
        System.out.println(studentA.equals(studentB));

        studentSet.add(studentA);
        studentSet.add(studentB);
        for (Student student : studentSet) {
            System.out.println(student.toString());
        }
    }
}
