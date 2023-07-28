package Day27_7_2023.Test;

import Day27_7_2023.JDBC.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class TestJDBC {
    // Create Connection
    public static Connection connection = JDBCUtil.getConnection();

    public static void main(String[] args) {

            // Test connection initialization
            JDBCUtil.printStatus(connection);

            // Step 3: Execute SQL statement

            // Drop table
            DROP();

            // Create table
            CREATE();

            // Select
            SELECT();

            // Insert
            INSERT();

            // Update
            UPDATE();

            // Delete
            DELETE();


    }

    // Handle the result set
    public static void execute(Connection connection, String sql) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            boolean hasResultSet = stmt.execute(sql);
            if (hasResultSet) {
                System.out.println("Query executed successfully");
            } else {
                System.out.println("Query executed successfully");
            }
            SQLWarning warning = stmt.getWarnings();
            while (warning != null) {
                System.out.println("Warning: " + warning.getMessage());
                warning = warning.getNextWarning();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    JDBCUtil.printStatus(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void CREATE(){
         String createTableSql = "CREATE TABLE student (" +
                "id INT PRIMARY KEY," +
                "first_name VARCHAR(50) NOT NULL," +
                "last_name VARCHAR(50) NOT NULL," +
                "age INT," +
                "gender VARCHAR(10)," +
                "email VARCHAR(100)," +
                "phone VARCHAR(20)," +
                "address VARCHAR(200)," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" +
                ");";
         execute(connection, createTableSql);
    }

    public static void SELECT(){
        String selectSql = "SELECT * FROM student";
        execute(connection, selectSql);
    }

    public static void INSERT(){
        String insertSql = "INSERT INTO Student (id, first_name, last_name, age, gender, email, phone, address)" +
                "VALUES ('A', 'Nguyen Van', 26, 'Nam', 'bnguyenvan@example.com', '0378453296', 'Hoan Kiem')";
        execute(connection, insertSql);
    }

    public static void UPDATE(){
        String updateSql = "UPDATE student SET first_name = 'Nguyen Tuan' WHERE id = 1";
        execute(connection, updateSql);
    }

    public static void DELETE(){
        String deleteSql = "DELETE FROM student WHERE id ='1'";
        execute(connection, deleteSql);
    }

    public static void DROP(){
        String dropSql = "DROP TABLE student";
        execute(connection, dropSql);
    }

}
