package command;

import registry.LibraryCatalog;

public class DeleteBookCommand implements Command{
    private final LibraryCatalog catalog;
    private final String isbn;

    public DeleteBookCommand(String isbn) {
        this.catalog = LibraryCatalog.getInstance();
        this.isbn = isbn;
    }

    @Override
    public void execute() {
        catalog.deleteBook(isbn);
        System.out.println("Book deleted successfully");
    }
}
