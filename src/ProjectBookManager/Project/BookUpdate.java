package ProjectBookManager.Project;

import java.util.List;
import java.util.Scanner;

public class BookUpdate {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Book> bookList = Database.takingBookList();
    private static int bookId;
    private static String bookTitle;
    private static String bookAuthor;
    private static int bookYearPublish;


    private static boolean validateId(int id) throws Exception {
        boolean validId = true;
        int count = 0;
        for (Book book : bookList) {
            if (id == book.getBookId()) {
                count++;
                validId = true;
            }
        }
        if (count == 0) {
            validId = false;
            throw new Exception("Invalid Id.");
        }
        return validId;
    }

    private static void validateTilte() throws Exception {
        if (bookTitle.isEmpty()) {
            throw new Exception("Book title cannot be empty.");
        }
        if (bookTitle.length() <= 10) {
            throw new Exception("Book title is too short, make it longer than 10.");
        }
    }

    private static void validateAuthor() throws Exception {
        if (bookAuthor.isEmpty()) {
            throw new Exception("Book author cannot be empty.");
        }
    }

    private static void validateYear() throws Exception {
        if (bookYearPublish < 0 || bookYearPublish > 2023) {
            throw new Exception("Invalid year of publication.");
        }
    }

    public void updatingBook() {
        System.out.println("This is a list of book");
        for (Book book : bookList) {
            System.out.println(book);
        }
        try {
            System.out.println("Please type bookId that you want to update");
            bookId = scanner.nextInt();
            scanner.nextLine();
            validateId(bookId);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        for (Book book : bookList) {
            if (bookId == book.getBookId()) {
                System.out.println("This is the information of book you want to update: ");
                System.out.println(book);
                boolean inputValid = false;
                while (!inputValid) {
                    try {
                        System.out.println("Please enter the book title:");
                        bookTitle = scanner.nextLine();
                        validateTilte();
                        book.setBookTitle(bookTitle);
                        System.out.println("Please enter the book author:");
                        bookAuthor = scanner.nextLine();
                        validateAuthor();
                        book.setBookAuthor(bookAuthor);
                        System.out.println("Please enter the year of publication:");
                        bookYearPublish = scanner.nextInt();
                        scanner.nextLine();
                        validateYear();
                        book.setBookYearPublish(bookYearPublish);

                        inputValid = true;
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                }
            }
        }
    }
}
