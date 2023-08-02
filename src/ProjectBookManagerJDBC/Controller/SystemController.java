package ProjectBookManagerJDBC.Controller;

import ProjectBookManagerJDBC.service.BookService;

import java.util.Scanner;

public class SystemController {

    public static void searching() {
        BookService.BookSearch.searchingBook();
    }
    public static void  deleting() {
        BookService.BookDelete.deletingBook();
    }
    public static void updating() {
        BookService.BookUpdate.updatingBook();
    }
    public static void inserting() {
        BookService.BookInsert.insertingBook();
    }
}
