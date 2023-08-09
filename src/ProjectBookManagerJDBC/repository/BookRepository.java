package ProjectBookManagerJDBC.repository;

import Day27_7_2023.JDBC.JDBCUtil;
import ProjectBookManagerJDBC.domain.BookCategory;
import ProjectBookManagerJDBC.domain.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookRepository implements RepositoryInterface<Book> {

    @Override
    public int insert(Book book) {

        // try-with-resource => automatically close the connection and statement
        int result = 0;
        try (Connection con = JDBCUtil.getConnection()) {

            // Start transaction manually
            con.setAutoCommit(false);
            try(Statement stmt = con.createStatement()){
                String sql = "INSERT INTO book (bookId, bookTitle, bookAuthor, bookYearPublish, categoryId)" +
                        "VALUES (" + book.getBookId() + ", '" +
                        book.getBookTitle() + "', '" +
                        book.getBookAuthor() + "', " +
                        book.getBookYearPublish() + ", '" +
                        book.getBookCategory().getCategoryId() + "');";
                result = stmt.executeUpdate(sql);
                System.out.println("Query executed successfully: " + sql);
                System.out.println(result + " row(s) affected");

                // Commit the transaction if everything is successful
                con.commit();
            }catch (SQLException e){
                e.printStackTrace();

                // Rollback the transaction if an exception occurs
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Book book) {
        // try-with-resource => automatically close the connection and statement
        int result = 0;
        try (Connection con = JDBCUtil.getConnection(); Statement stmt = con.createStatement()) {
            String sql = "UPDATE book " +
                    "SET " +
                    "bookId = " + book.getBookId() + ", " +
                    "bookTitle = '" + book.getBookTitle() + "', " +
                    "bookAuthor = '" + book.getBookAuthor() + "', " +
                    "bookYearPublish = " + book.getBookYearPublish() + ", " +
                    "categoryID = " + book.getBookCategory().getCategoryId() + " " +
                    "WHERE bookId = " + book.getBookId() + ";";
            result = stmt.executeUpdate(sql);
            System.out.println("Query executed successfully: " + sql);
            System.out.println(result + " row(s) affected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int bookID) {
        // try-with-resource => automatically close the connection and statement
        int result = 0;
        try (Connection con = JDBCUtil.getConnection(); Statement stmt = con.createStatement()) {
            String sql = "DELETE FROM book " +
                    "WHERE bookId = " + bookID + ";";
            result = stmt.executeUpdate(sql);
            System.out.println("Query executed successfully: " + sql);
            System.out.println(result + " row(s) affected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Book> selectAll() {
        // try-with-resource => automatically close the connection and statement
        ArrayList<Book> bookList = new ArrayList<>();
        try (Connection con = JDBCUtil.getConnection(); Statement stmt = con.createStatement()) {
            String sql = "SELECT book.bookId, book.bookTitle, book.bookAuthor, book.bookYearPublish, book_category.categoryID,book_category.bookType\n" +
                    "FROM book inner join book_category ON book.categoryID = book_category.categoryID ORDER BY book.bookId;";
            try (ResultSet resultSet = stmt.executeQuery(sql)) {
                while(resultSet.next()){
                int bookId = resultSet.getInt("bookId");
                String bookTitle = resultSet.getString("bookTitle");
                String bookAuthor = resultSet.getString("bookAuthor");
                int bookYearPublish = resultSet.getInt("bookYearPublish");
                String bookType = resultSet.getString("bookType");
                int categoryID = resultSet.getInt("categoryID");
                Book book = new Book(bookId, bookTitle, bookAuthor, bookYearPublish, new BookCategory(categoryID, bookType));
                bookList.add(book);
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
