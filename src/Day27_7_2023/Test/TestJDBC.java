package Day27_7_2023.Test;

import Day27_7_2023.JDBC.CategoryDAO;

import java.sql.Connection;

public class TestJDBC {
    public static void main(String[] args) {
        // Test connection initialization
        Connection connection = CategoryDAO.getConnection();
        CategoryDAO.printStatus(connection);

        // Test whether connection is closed
        CategoryDAO.closeConnection(connection);
        CategoryDAO.printStatus(connection);
    }
}
