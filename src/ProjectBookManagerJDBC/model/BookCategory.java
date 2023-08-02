package ProjectBookManagerJDBC.model;

public class BookCategory {
    private int categoryId;
    private String bookType;

    public BookCategory() {
    }

    public BookCategory(int categoryId, String bookType) {
        this.categoryId = categoryId;
        this.bookType = bookType;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "categoryId=" + categoryId +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}
