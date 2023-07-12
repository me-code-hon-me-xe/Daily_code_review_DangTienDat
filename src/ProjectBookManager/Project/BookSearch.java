package ProjectBookManager.Project;

import java.util.*;

public class BookSearch {
    public static int cacheSize = 6;
    private static final Database database = new Database();
    private static final List<Book> bookList = Database.takingBookList();
    private static List<Book> keyBookList;
    private static final LinkedList<String> bookCache = new LinkedList<>();
    private static final Map<String, List<Book>> bookMap = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void searchingBook() {
        System.out.println("Please type book Title or Keyword to search:");
        String inputString = scanner.nextLine().toLowerCase();
        checkKeyword(inputString);

    }

    public static void checkKeyword(String string) {
        int count = 0;
        if (!bookMap.containsKey(string)) {
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
                Thread.sleep(2000);
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
        } else {
            System.out.println("This is the list of book containing keyword: \"" + string + "\"");
            for (Book book : bookMap.get(string)) {
                System.out.println(book);
            }
        }

    }
}
