package Day11_7_2023.Project;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerLibrary {
    static ArrayList<Book> bookList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee", 1960);
        Book book2 = new Book(2, "Hello the Darkness", "George Orwell", 1949);
        Book book3 = new Book(3, "Pride and Prejudice", "Jane Austen", 1813);
        Book book4 = new Book(4, "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book5 = new Book(5, "To the Lighthouse", "Virginia Woolf", 1927);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        runMenu();
    }
    static void runMenu(){
        int userInputNumber;
        System.out.println("This is library menu: \n"
                + "1. Inserting\n"
                + "2. Updating \n"
                + "3. Deleting \n"
                + "4. Searching \n"
                + "Please choose your options: \n");
        userInputNumber = scanner.nextInt();
        scanner.nextLine();
        switch(userInputNumber){
            case 1:
                inserting();
                break;
            case 2:
                updating();
                break;
            case 3:
                deleting();
                break;
            case 4:
                searching();
                break;
        }

    }

    private static void searching() {
    }

    private static void deleting() {
    }

    private static void updating() {
    }

    private static void inserting() {
        boolean duplicate = false;
        System.out.println("Current Book in list: "
                        + bookList);
        while(!duplicate){
        System.out.println("Please fill in book information: ");
        System.out.println("Please enter the book ID:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        for(int i = 1, size = bookList.size(); i<size; i++){
            if(bookId == i){
                System.out.println("Id is duplicated!");
                duplicate = true;

            }else{
                duplicate = false;
            }
        }
        System.out.println("Please enter the book title:");
        String bookTitle = scanner.nextLine();
        System.out.println("Please enter the book author:");
        String bookAuthor = scanner.nextLine();
        System.out.println("Please enter the year of publication:");
        int bookYearPublish = scanner.nextInt();
        scanner.nextLine();
            Book newBook = new Book(bookId,bookTitle,bookAuthor,bookYearPublish);
            bookList.add(newBook);
        }
    }
}
