package ProjectBookManager.Project;

import java.util.*;

public class BookSearch {
    private static final Database database = new Database();
    private static final List<Book> bookList = Database.takingBookList();
    private static final LinkedList<String> bookCache = new LinkedList<>();
    private static final Map<String, List<Book>> bookMap = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static int cacheSize = 6;
    public static int bloomSize = 10;
    public static int[] bloomArray = new int[bloomSize];
    private static List<Book> keyBookList;

    public static void searchingBook() {
        System.out.println("Please type book Title or Keyword to search:");
        String inputString = scanner.nextLine().toLowerCase();
        checkKeyword(inputString);
    }

    public static void checkKeyword(String string) {
        int count = 0;

        if (negative(string)) {
            try {
                sleepDemo(10000);
                keyBookList = new ArrayList<>();
                for (Book book : bookList
                ) {
                    if (book.getBookTitle().toLowerCase().contains(string)) {
                        keyBookList.add(book);
                        count++;
                        count++;
                    }
                }
                try {
                    System.out.println("This is the list of book containing keyword: \"" + string + "\"");

                    for (Book book : keyBookList
                    ) {
                        System.out.println(book);
                    }
                } catch (Exception e) {
                }

                if (count == 0) {
                    System.out.println("Keyword " + string + " does not exit!");

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
            } catch (Exception e) {
            }

        } else {
            try {
                sleepDemo(2000);
                System.out.println("This is the list of book containing keyword: \"" + string + "\"");

                for (Book book : bookMap.get(string)) {
                    System.out.println(book);
                }
            } catch (Exception e) {
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

    public static boolean negative(String string) {
        boolean negative = false;
        int hashValue = string.hashCode();
        int h1 = hashOne(hashValue);
        int h2 = hashTwo(hashValue);
        int h3 = hashThree(hashValue);
        if (bloomArray[h1] == 0) {
            bloomArray[h1] = 1;
            negative = true;
        }
        if (bloomArray[h2] == 0) {
            bloomArray[h2] = 1;
            negative = true;
        }
        if (bloomArray[h3] == 0) {
            bloomArray[h3] = 1;
            negative = true;
        }
        if (negative) {
            System.out.println(string + " not exit");
        } else {
            System.out.println(string + " was probably exit");
        }
        return negative;
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
