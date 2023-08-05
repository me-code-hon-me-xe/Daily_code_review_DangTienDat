package ProjectBookManagerJDBC.domain;

public class Book {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private int bookYearPublish;
    private int categoryID;
    private BookCategory bookCategory;

    public Book() {
    }

    public Book(int bookId, String bookTitle, String bookAuthor, int bookYearPublish, BookCategory bookCategory) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYearPublish = bookYearPublish;
        this.bookCategory = bookCategory;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookYearPublish() {
        return bookYearPublish;
    }

    public void setBookYearPublish(int bookYearPublish) {
        this.bookYearPublish = bookYearPublish;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void print() {
        System.out.printf("| %-6d | %-20s | %-20s | %-6d | %-20s |%n" + "----------------------------------------------------------------------------------------%n", bookId, bookTitle, bookAuthor, bookYearPublish, bookCategory.getBookType());
    }
}
