package ProjectBookManagerJDBC.view;

import ProjectBookManagerJDBC.Controller.SystemController;

import java.util.Scanner;

public class LibraryView {
    public static int userInputNumber;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            runningMenu();
        }
    }


    public static void runningMenu() {

        System.out.println("This is library menu: \n"
                + "1. Inserting\n"
                + "2. Updating \n"
                + "3. Deleting \n"
                + "4. Searching \n"
                + "Please choose your options:");
        try {
            if (scanner.hasNextInt()) {
                userInputNumber = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (userInputNumber) {
                        case 1:
                            SystemController.inserting();
                            break;
                        case 2:
                            SystemController.updating();
                            break;
                        case 3:
                            SystemController.deleting();
                            break;
                        case 4:
                            SystemController.searching();
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
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        };
    }

    private static void validateChoice() throws Exception {
        if (1 > userInputNumber || userInputNumber > 4) {
            throw new Exception("Invalid Choice Number");
        }
    }

}
