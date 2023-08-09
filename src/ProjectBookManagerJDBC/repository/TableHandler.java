package ProjectBookManagerJDBC.repository;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class TableHandler {
    public static Connection connection = DBconnection.getConnection();

    public static void main(String[] args) {

        // Test connection initialization
        DBconnection.printStatus(connection);

        //Execute SQL statement

        // Create table
//        CREATEBOOK();
        CREATEBOOKCATEGORY();

        // Drop table
//        DROP();

    }
    public static void execute(Connection connection, String sql) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            boolean hasResultSet = statement.execute(sql);
            if (hasResultSet) {
                System.out.println("Query executed successfully");
            } else {
                System.out.println("Query executed successfully");
            }
            SQLWarning warning = statement.getWarnings();
            while (warning != null) {
                System.out.println("Warning: " + warning.getMessage());
                warning = warning.getNextWarning();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                    DBconnection.printStatus(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void CREATEBOOK(){
        String createTableSql = "CREATE TABLE book (" +
                "bookId INT PRIMARY KEY," +
                "bookTitle VARCHAR(50) NOT NULL," +
                "bookAuthor VARCHAR(50) NOT NULL," +
                "bookYearPublish INT," +
                "bookType VARCHAR(50)" +
                "CONSTRAINT fk_book_bookCategory FOREIGN KEY (categoryID) REFERENCES book_category(categoryID)" +
                ");";
        execute(connection, createTableSql);
    }

    public static void CREATEBOOKCATEGORY(){
        String createTableSql = "CREATE TABLE book_category (" +
                "categoryID INT PRIMARY KEY," +
                "bookTitle VARCHAR(50) NOT NULL" +
                ");";
        execute(connection, createTableSql);
    }

    public static void DROP(){
        String dropSql = "DROP TABLE book";
        execute(connection, dropSql);
    }
}
