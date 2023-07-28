package Day27_7_2023.dao;

import Day27_7_2023.JDBC.JDBCUtil;
import Day27_7_2023.model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO implements DAOInterface<Student>{

    public static StudentDAO getInstance(){
        return new StudentDAO();
    }

    @Override
    public int insert(Student st) {
        try{
            // Create connection
            Connection con = JDBCUtil.getConnection();

            // Create Statement Object
            Statement stmt = con.createStatement();

            // Implement command
            String sql = "INSERT INTO Student (id, first_name, last_name, age, gender, email, phone, address, created_at, updated_at)" +
                    "VALUES (" +
                    st.getId() + ", " +
                    st.getFirst_name() + ", " +
                    st.getLast_name() + ", " +
                    st.getAge() + ", " +
                    st.getGender() + ", " +
                    st.getEmail() + ", " +
                    st.getPhone() + ", " +
                    st.getAddress() + ", " +
                    st.getCreated_at() + ", " +
                    st.getUpdated_at() + ");";

            int result = stmt.executeUpdate(sql);

            System.out.println("Query executed successfully: " + sql);
            System.out.println( result + " row(s) affected");

            JDBCUtil.closeConnection(con);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int udpate(Student student) {
        return 0;
    }

    @Override
    public int delete(Student student) {
        return 0;
    }

    @Override
    public ArrayList<Student> selectAll() {
        return null;
    }

    @Override
    public Student selectById(Student student) {
        return null;
    }

    @Override
    public ArrayList<Student> selectByCondition(String condtition) {
        return null;
    }
}

