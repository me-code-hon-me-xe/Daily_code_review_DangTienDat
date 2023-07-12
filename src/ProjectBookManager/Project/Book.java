package ProjectBookManager.Project;

public class Book {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private int bookYearPublish;

    public Book(int bookId, String bookTitle, String bookAuthor, int bookYearPublish) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYearPublish = bookYearPublish;
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

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookYearPublish=" + bookYearPublish +
                '}';
    }
}
