package ProjectBookManager.Project;

import java.util.List;
import java.util.Scanner;

public class BookDelete {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Database database = new Database();
    private static final List<Book> bookList = Database.takingBookList();
    private static int bookId;

    private static boolean validateId(int id) throws Exception {
        boolean validId = true;
        int count = 0;
        for (Book book : bookList) {
            if (id == book.getBookId()) {
                count++;
                validId = true;
                bookList.remove(book);
            }
        }
        if (count == 0) {
            validId = false;
            throw new Exception("Invalid Id.");
        }
        return validId;

    }

    public void deletingBook() {
        System.out.println("This is a list of book");
        for (Book book : bookList) {
            System.out.println(book);
        }
        try {
            System.out.println("Please type bookId that you want to delete");
            bookId = scanner.nextInt();
            scanner.nextLine();
            validateId(bookId);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
