package command;

import model.Book;
import registry.LibraryCatalog;

public class UpdateBookCommand implements  Command{
    private final LibraryCatalog catalog;
    private final String isbn;
    private final Book updatedBook;

    public UpdateBookCommand(String isbn, Book updatedBook) {
        this.catalog = LibraryCatalog.getInstance();
        this.isbn = isbn;
        this.updatedBook = updatedBook;
    }

    @Override
    public void execute() {
        catalog.updateBook(isbn, updatedBook);
        System.out.println("Book updated successfully");
    }

}
