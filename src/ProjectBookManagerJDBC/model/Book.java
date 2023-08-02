package ProjectBookManagerJDBC.model;

public class Book {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private int bookYearPublish;
    private String bookType;

    public Book() {
    }

    public Book(int bookId, String bookTitle, String bookAuthor, int bookYearPublish, String bookType) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYearPublish = bookYearPublish;
        this.bookType = bookType;
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

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }


    public void print() {
        System.out.printf("| %-6d | %-20s | %-20s | %-6d | %-20s |%n" + "----------------------------------------------------------------------------------------%n", bookId, bookTitle, bookAuthor, bookYearPublish, bookType);
    }
}
