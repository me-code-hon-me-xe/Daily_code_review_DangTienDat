package Day27_7_2023.dao;

import Day27_7_2023.JDBC.JDBCUtil;
import Day27_7_2023.model.Student;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class StudentDAO implements DAOInterface<Student> {

    public static StudentDAO getInstance() {
        return new StudentDAO();
    }

    @Override
    public int insert(Student st) {
        int result = 0;
        try {
            // Create connection
            Connection con = JDBCUtil.getConnection();

            // Create Statement Object
            Statement stmt = con.createStatement();

            // Implement command
            String sql = "INSERT INTO student (id, first_name, last_name, age, gender, email, phone, address, created_at, updated_at)" +
                    "VALUES (" + st.getId() + ", '" +
                    st.getFirst_name() + "', '" +
                    st.getLast_name() + "', " +
                    st.getAge() + ", '" +
                    st.getGender() + "', '" +
                    st.getEmail() + "', '" +
                    st.getPhone() + "', '" +
                    st.getAddress() + "', '" +
                    st.getCreated_at() + "', '" +
                    st.getUpdated_at() + "');";
            result = stmt.executeUpdate(sql);

            System.out.println("Query executed successfully: " + sql);
            System.out.println(result + " row(s) affected");

            // Close connection
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Student st) {
        int result = 0;
        try {
            // Create connection
            Connection con = JDBCUtil.getConnection();

            // Create Statement Object
            Statement stmt = con.createStatement();

            // Implement command
            String sql = "UPDATE student " +
                    "SET " +
                    "id = " + st.getId() + ", " +
                    "first_name = '" + st.getFirst_name() + "', " +
                    "last_name = '" + st.getLast_name() + "', " +
                    "age = " + st.getAge() + ", " +
                    "gender = '" + st.getGender() + "', " +
                    "email = '" + st.getEmail() + "', " +
                    "phone = '" + st.getPhone() + "', " +
                    "address = '" + st.getAddress() + "', " +
                    "updated_at = '" + st.getUpdated_at() + "' " +
                    "WHERE id = " + st.getId() + ";";

            result = stmt.executeUpdate(sql);

            System.out.println("Query executed successfully: " + sql);
            System.out.println(result + " row(s) affected");

            // Close connection
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Student st) {
        int result = 0;
        try {
            // Create connection
            Connection con = JDBCUtil.getConnection();

            // Create Statement Object
            Statement stmt = con.createStatement();

            // Implement command
            String sql = "DELETE FROM student " +
                    "WHERE id = " + st.getId() + ";";

            result = stmt.executeUpdate(sql);

            System.out.println("Query executed successfully: " + sql);
            System.out.println(result + " row(s) affected");

            // Close connection
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Student> selectAll() {
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            // Create connection
            Connection con = JDBCUtil.getConnection();

            // Create Statement Object
            Statement stmt = con.createStatement();

            // Implement command
            String sql = "SELECT * FROM student";

            ResultSet resultSet = stmt.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                LocalDateTime created_at = resultSet.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updated_at = resultSet.getTimestamp("updated_at").toLocalDateTime();

                Student student = new Student(id, first_name, last_name, age
                , gender, email,phone, address,
                        created_at, updated_at);
                result.add(student);
            }
            System.out.println("Query executed successfully: " + sql);

            // Close connection
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Student selectById(Student st) {
        Student result = null;
        try {
            // Create connection
            Connection con = JDBCUtil.getConnection();

            // Create Statement Object
            Statement stmt = con.createStatement();

            // Implement command
            String sql = "SELECT * FROM student " +
                    "WHERE id = " + st.getId() + ";";

            ResultSet resultSet = stmt.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                LocalDateTime created_at = resultSet.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updated_at = resultSet.getTimestamp("updated_at").toLocalDateTime();

                Student student = new Student(id, first_name, last_name, age
                        , gender, email,phone, address,
                        created_at, updated_at);
                result = student;
            }
            System.out.println("Query executed successfully: " + sql);

            // Close connection
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Student> selectByCondition(String condition) {
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            // Create connection
            Connection con = JDBCUtil.getConnection();

            // Create Statement Object
            Statement stmt = con.createStatement();

            // Implement command
            String sql = "SELECT * FROM student WHERE " + condition;

            ResultSet resultSet = stmt.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                LocalDateTime created_at = resultSet.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updated_at = resultSet.getTimestamp("updated_at").toLocalDateTime();

                Student student = new Student(id, first_name, last_name, age
                        , gender, email,phone, address,
                        created_at, updated_at);
                result.add(student);
            }
            System.out.println("Query executed successfully: " + sql);

            // Close connection
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

