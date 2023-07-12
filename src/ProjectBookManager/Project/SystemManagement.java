package ProjectBookManager.Project;

import java.util.Scanner;

public class SystemManagement {
    public static int userInputNumber;
    static Scanner scanner = new Scanner(System.in);

    public static void runningMenu() {

        System.out.println("This is library menu: \n"
                + "1. Inserting\n"
                + "2. Updating \n"
                + "3. Deleting \n"
                + "4. Searching \n"
                + "Please choose your options: \n");
        if (scanner.hasNextInt()) {
            userInputNumber = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (userInputNumber) {
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
                    default:
                        validateChoice();
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } else {
            String input = scanner.nextLine();
            throw new IllegalArgumentException("Invalid input: " + input + ". Please enter a valid number.");
        }

    }

    private static void validateChoice() throws Exception {
        if (1 > userInputNumber || userInputNumber > 4) {
            throw new Exception("Invalid Choice Number");
        }
    }

    private static void searching() {
        BookSearch bookSearch = new BookSearch();
        BookSearch.searchingBook();
    }

    private static void deleting() {
        BookDelete bookDelete = new BookDelete();
        bookDelete.deletingBook();
    }

    private static void updating() {
        BookUpdate bookUpdate = new BookUpdate();
        bookUpdate.updatingBook();
    }

    private static void inserting() {
        BookInsert bookInsert = new BookInsert();
        bookInsert.insertingBook();
    }
}
