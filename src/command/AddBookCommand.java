package command;

import model.Book;
import registry.LibraryCatalog;

public class AddBookCommand implements  Command{

    private final LibraryCatalog catalog;
    private final Book book;

    public AddBookCommand(Book book) {
        this.catalog = LibraryCatalog.getInstance();
        this.book = book;
    }

    @Override
    public void execute() {
        catalog.addBook(book);
        System.out.println("Book added successfully");
    }
}
