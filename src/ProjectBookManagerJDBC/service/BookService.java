package ProjectBookManagerJDBC.service;

import ProjectBookManagerJDBC.repository.BookRepository;
import ProjectBookManagerJDBC.model.Book;

import java.util.*;

public class BookService {
    private static List<Book> Database() {
        BookRepository bookDAO = new BookRepository();
        return bookDAO.selectAll();
    }

    public static class BookInsert {
        private static List<Book> bookList = Database();
        private static Scanner scanner = new Scanner(System.in);
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

        public static void insertingBook() {
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
//                Book newBook = new Book(bookTitle, bookAuthor, bookYearPublish);
//                bookList.add(newBook);
                    inputValid = true;

                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
        }
    }

    public static class BookSearch {
        private static final List<Book> database = Database();
        private static final LinkedList<String> bookCache = new LinkedList<>();
        private static final Map<String, List<Book>> bookMap = new HashMap<>();
        private static final Scanner scanner = new Scanner(System.in);
        public static int cacheSize = 6;
        public static int bloomSize = 1000;
        public static int[] bloomArray = new int[bloomSize];
        private static List<Book> keyBookList;

        public static void searchingBook() {
            System.out.println("Please type book Title or Keyword to search:");
            String inputString = scanner.nextLine().toLowerCase();
            checkKeyword(inputString);
        }

        public static void checkKeyword(String string) {
            int count = 0;
            if (bloomFilter(string) == false) {
                sleepDemo(10000);
                keyBookList = new ArrayList<>();
                for (Book book : database
                ) {
                    if (book.getBookTitle().toLowerCase().contains(string)) {
                        keyBookList.add(book);
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Keyword " + "\"" + string + "\"" + " does not exit in the database!");
                } else {
                    System.out.println("\nThis is the list of book containing keyword: \"" + string + "\"");
                    System.out.printf("----------------------------------------------------------------------------------------%n");
                    System.out.printf("                                       Book List                                        %n");
                    System.out.printf("----------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-6S | %-20s | %-20s | %-6s | %-20s |%n" + "----------------------------------------------------------------------------------------%n", "ID", "Title", "Author", "Year", "Type");
                    for (Book book : keyBookList
                    ) {
                        book.print();
                    }
                    bookMap.put(string, keyBookList);
                    if (bookMap.size() <= cacheSize) {
                        bookCache.add(string);
                    } else {
                        System.out.println("Before remove" + bookCache);
                        String lastString = bookCache.getLast();
                        bookCache.removeFirst();
                        System.out.println("After remove" + bookCache);
                        bookMap.remove(lastString);
                        bookCache.addLast(string);
                        System.out.println("After add" + bookCache);
                    }
                }
            } else {
                sleepDemo(2000);
                if (bookCache.contains(string)) {
                    System.out.println("\nThis is the list of book containing keyword: \"" + string + "\"");
                    System.out.printf("----------------------------------------------------------------------------------------%n");
                    System.out.printf("                                       Book List                                        %n");
                    System.out.printf("----------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-6S | %-20s | %-20s | %-6s | %-20s |%n" + "----------------------------------------------------------------------------------------%n", "ID", "Title", "Author", "Year", "Type");
                    for (Book book : bookMap.get(string)) {
                        book.print();
                    }
                } else {
                    System.out.println("Keyword " + "\"" + string + "\"" + " does not exit in the database!");
                }
            }
        }

        public static void sleepDemo(int waitTime) {
            try {
                for (int i = 1, size = waitTime / 1000; i <= size; i++) {
                    System.out.print(i + " ");
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
            }
        }

        public static boolean bloomFilter(String string) {
            int count = 0;
            boolean exit = false;
            int hashValue = string.hashCode();
            int h1 = hashOne(hashValue);
            int h2 = hashTwo(hashValue);
            int h3 = hashThree(hashValue);

            if (bloomArray[h1] == 0) {
                bloomArray[h1] = 1;
            } else {
                count++;
            }
            ;
            if (bloomArray[h2] == 0) {
                bloomArray[h2] = 1;
            } else {
                count++;
            }
            if (bloomArray[h3] == 0) {
                bloomArray[h3] = 1;
            } else {
                count++;
            }
            if (count == 3) {
                System.out.println("\"" + string + "\"" + " was probably exit in the cache. Please wait!");
                exit = true;
            } else {
                System.out.println("\"" + string + "\"" + " was not exit in the cache. Please wait!");
                exit = false;
            }
            return exit;
        }

        public static int hashOne(int hashValue) {
            return hashValue % bloomSize;
        }

        public static int hashTwo(int hashValue) {
            return (hashValue / 2) % bloomSize;
        }

        public static int hashThree(int hashValue) {
            return (hashValue / 3) % bloomSize;
        }
    }

    public static class BookUpdate {
        private static final Scanner scanner = new Scanner(System.in);
        private static final List<Book> bookList = Database();
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

        public static void updatingBook() {
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

    public static class BookDelete {
        private static final Scanner scanner = new Scanner(System.in);
        private static final List<Book> database = Database();
        private static final BookRepository bookDao = new BookRepository();
        private static int bookId;

        public static void deletingBook() {
            System.out.println("This is a list of book");
            System.out.printf("----------------------------------------------------------------------------------------%n");
            System.out.printf("                                       Book List                                        %n");
            System.out.printf("----------------------------------------------------------------------------------------%n");
            System.out.printf("| %-6S | %-20s | %-20s | %-6s | %-20s |%n" + "----------------------------------------------------------------------------------------%n", "ID", "Title", "Author", "Year", "Type");
            for (Book book : database) {
                book.print();
            }
            try {
                System.out.println("Please type bookId that you want to delete: ");
                bookId = scanner.nextInt();
                scanner.nextLine();
                validateId(bookId);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        private static boolean validateId(int id) throws Exception {
            boolean validId = true;
            int count = 0;
            for (Book book : database) {
                if (id == book.getBookId()) {
                    count++;
                    validId = true;
                    bookDao.delete(id);
                }
            }
            if (count == 0) {
                validId = false;
                throw new Exception("Invalid Id.");
            }
            return validId;

        }
    }
}

