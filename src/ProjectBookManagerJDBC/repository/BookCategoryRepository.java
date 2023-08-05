package ProjectBookManagerJDBC.repository;

import ProjectBookManagerJDBC.domain.BookCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookCategoryRepository implements RepositoryInterface<BookCategory>{
    @Override
    public int insert(BookCategory bookCategory) {
        return 0;
    }

    @Override
    public int update(BookCategory bookCategory) {
        return 0;
    }

    @Override
    public int delete(int i) {
        return 0;
    }

    @Override
    public ArrayList<BookCategory> selectAll() {
        ArrayList<BookCategory> bookCategories = new ArrayList<>();
        try{
            //Create connection
            Connection connection = DBconnection.getConnection();

            // Create statement
            Statement statement = connection.createStatement();

            // SQL
            String sql = "SELECT * \n" +
                    "FROM book_category  ORDER BY categoryID;";

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int categoryId = resultSet.getInt("categoryId");
                String bookType = resultSet.getString("bookType");
                BookCategory bookCategory = new BookCategory(categoryId, bookType);
                bookCategories.add(bookCategory);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return bookCategories;
    }

    public static void main(String[] args) {
        BookCategoryRepository bookCategoryRepository = new BookCategoryRepository();
        ArrayList<BookCategory> bookCategories = bookCategoryRepository.selectAll();
        for (BookCategory bookCategory: bookCategories) {
            System.out.println(bookCategory.toString());
        }
    }
}
