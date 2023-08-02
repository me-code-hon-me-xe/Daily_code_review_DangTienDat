package ProjectBookManagerJDBC.repository;

import Day27_7_2023.JDBC.JDBCUtil;
import ProjectBookManagerJDBC.model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookRepository implements RepositoryInterface<Book> {

    @Override
    public int insert(Book book) {
        return 0;
    }

    @Override
    public int update(Book book) {
        return 0;
    }

    @Override
    public int delete(int bookID) {
        int result = 0;
        try {
            // Create connection
            Connection connection = JDBCUtil.getConnection();

            // Create Statement Object
            Statement statement = connection.createStatement();

            // Implement command
            String sql = "DELETE FROM book " +
                    "WHERE bookId = " + bookID + ";";

            result = statement.executeUpdate(sql);

            System.out.println("Query executed successfully: " + sql);
            System.out.println(result + " row(s) affected");

            // Close connection
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Book> selectAll() {
        ArrayList<Book> bookList = new ArrayList<>();
        try{
            //Create connection
            Connection connection = DBconnection.getConnection();

            // Create statement
            Statement statement = connection.createStatement();

            // SQL
            String sql = "SELECT book.bookId, book.bookTitle, book.bookAuthor, book.bookYearPublish, book_category.bookType\n" +
                    "FROM book inner join book_category ON book.categoryID = book_category.categoryID ORDER BY book.bookId;";

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int bookId = resultSet.getInt("bookId");
                String bookTitle = resultSet.getString("bookTitle");
                String bookAuthor = resultSet.getString("bookAuthor");
                int bookYearPublish = resultSet.getInt("bookYearPublish");
                String bookType = resultSet.getString("bookType");
                Book book = new Book();
                book.setBookId(bookId);
                book.setBookTitle(bookTitle);
                book.setBookAuthor(bookAuthor);
                book.setBookYearPublish(bookYearPublish);
                book.setBookType(bookType);
                bookList.add(book);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Book selectById(Book book) {
        return null;
    }

    @Override
    public ArrayList<Book> selectByCondition(String condtition) {
        return RepositoryInterface.super.selectByCondition(condtition);
    }

    public static void main(String[] args) {

    }
}
