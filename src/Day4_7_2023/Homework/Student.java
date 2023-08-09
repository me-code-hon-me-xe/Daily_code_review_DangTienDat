package Day4_7_2023.Homework;

public class Student {
    static final int HASH_CODE = 31;
    int age;
    String name;

    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student other = (Student) obj;
            return name.equals(other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return HASH_CODE;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}
