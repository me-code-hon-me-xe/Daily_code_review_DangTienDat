package Day27_7_2023.JDBC;

import java.sql.*;

public class CategoryDAO {
    // Firstly, create the Connection between java and database
    public static Connection getConnection() {
        // Before connecting to database it will check whether the jdbc.Driver class
        // is added (Which means in reality if you want to use jdbc and connect to SQL compiler mySQL,
        // you need to add dependency for example <mysql.version> #ver_num </mysql>)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/store_management";
            String user = "root";
            String password = "dat2492002";

            return DriverManager.getConnection(url, user, password);
        } catch
        // Here we will use multiple try catch "|" for
        // "SQLException" of DriverManager.getConnection
        // and
        // "ClassNotFoundException" of Class.forName
        (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    // Create a closeConnection class so that the connection will
    // be closed after finishing query the data.
    public static void closeConnection(Connection c){
        try{
            if( c!= null){
                c.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void printStatus(Connection c){
        try {
            if(c != null){
                System.out.println("Connection closed: " + c.isClosed());
            }else{
                System.out.println("Connection closed: " + c.isClosed());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

