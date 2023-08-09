package ProjectBookManager.Project;

import java.util.List;
import java.util.Scanner;

public class BookInsert {
    private static  Database database = new Database();
    private static  List<Book> bookList = Database.takingBookList();
    private static  Scanner scanner = new Scanner(System.in);
    private static int bookId = 0;
    private static String bookTitle;
    private static String bookAuthor;
    private static int bookYearPublish;
    private static boolean duplicate;

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

    public void insertingBook() {
        boolean inputValid = false;
        while (!inputValid) {
            try {
                do {
                    System.out.println("Please fill in book information: ");
                    System.out.println("Please enter the book ID:");
                    bookId = scanner.nextInt();
                    scanner.nextLine();
                    duplicate = false;
                    for (Book book : bookList) {
                        if (bookId == book.getBookId()) {
                            duplicate = true;
                            System.out.println("Id is duplicated");
                            break;
                        } else {
                            duplicate = false;
                        }
                    }
                } while (duplicate);

                System.out.println("Please enter the book title:");
                bookTitle = scanner.nextLine();
                validateTilte();
                System.out.println("Please enter the book author:");
                bookAuthor = scanner.nextLine();
                validateAuthor();
                System.out.println("Please enter the year of publication:");
                bookYearPublish = scanner.nextInt();
                scanner.nextLine();
                validateYear();
                Book newBook = new Book(bookId, bookTitle, bookAuthor, bookYearPublish);
                bookList.add(newBook);
                inputValid = true;

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

}
