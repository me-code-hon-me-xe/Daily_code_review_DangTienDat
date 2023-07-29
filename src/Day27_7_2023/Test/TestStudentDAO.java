package Day27_7_2023.Test;

import Day27_7_2023.dao.StudentDAO;
import Day27_7_2023.model.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestStudentDAO {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        /* Test Insert */
        //        Student student1 = new Student(1, "A", "Nguyen Van", 26, "Nam", "bnguyenvan@example.com", "0378453296", "Hoan Kiem", localDateTime, localDateTime);
        //        Student student2 = new Student(2, "B", "Nguyen Van", 18, "Nam", "bnguyenvan@example.com", "0378453296", "Hoan Kiem", localDateTime, localDateTime);
        /*
        for (int i = 1; i <= 5; i++) {
            Student student = new Student(i, "S" + i, "Nguyen Van", 18, "Nam", "" + i + "nguyenvan@example.com", "0378453296", "Hoan Kiem", localDateTime, localDateTime);
            StudentDAO.getInstance().insert(student);
        }*/

        /* Test Update */
        /*
        Student student2 = new Student(3, "Dat", "Dang Tien", 20, "Nam", "bnguyenvan@example.com", "0378453296", "Hai Ba Trung", localDateTime, localDateTime);
        StudentDAO.getInstance().update(student2);
        */

        /* Test Delete */
        /*
        for (int i = 1; i <= 1000; i++) {
            Student student = new Student(i, "S" + i, "Nguyen Van", 18, "Nam", "" + i + "nguyenvan@example.com", "0378453296", "Hoan Kiem", localDateTime, localDateTime);
            StudentDAO.getInstance().delete(student);
        }
        */

        /* Test Select All*/
        /*
        ArrayList<Student> list = StudentDAO.getInstance().selectAll();
        for (Student student : list){
            System.out.println(student.toString());
        }
        */

        /* Test Select by ID*/
        /*
        Student find = new Student();
        find.setId(1);
        StudentDAO.getInstance().selectById(find);
        */

        /* Test Select by condition */
        /*
        ArrayList<Student> list2 = StudentDAO.getInstance().selectByCondition("age >= 20");
        for (Student student : list2){
            System.out.println(student.toString());
        }
        */
    }
}
