package Day4_7_2023.SelectionStatement;

import java.util.Scanner;

public class SwitchCase {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Book management website");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Update book information");
        System.out.println("4. Search for a book");
        System.out.println("5. Exit");

        System.out.println("Please Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Book is added");
                break;
            case 2:
                System.out.println("Book is removed");
                break;
            case 3:
                System.out.println("Book is updated");
                break;
            case 4:
                System.out.println("Searching for a book");
                break;
            case 5:
                System.out.println("Exiting!");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        scanner.close();
    }
}
