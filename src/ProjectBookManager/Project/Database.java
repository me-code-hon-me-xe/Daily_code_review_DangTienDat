package ProjectBookManager.Project;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Book> takingBookList() {
        ArrayList<Book> bookList = new ArrayList<>();
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee", 1960);
        Book book2 = new Book(2, "Hello the Darkness", "George Orwell", 1949);
        Book book3 = new Book(3, "Pride and Prejudice", "Jane Austen", 1813);
        Book book4 = new Book(4, "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book5 = new Book(5, "To the Lighthouse", "Virginia Woolf", 1927);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        return bookList;
    }
}
