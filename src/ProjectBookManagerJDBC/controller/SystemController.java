package ProjectBookManagerJDBC.controller;

import ProjectBookManagerJDBC.service.BookService;

public class SystemController {

    public static BookService bookService = new BookService();
    public static void searching() {
        bookService.search();
    }
    public static void  deleting() {
        bookService.delete();
    }
    public static void updating() {
        bookService.update();
    }
    public static void inserting() {
        bookService.insert();
    }
}
