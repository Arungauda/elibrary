package facade;


import command.AddBookCommand;
import command.Command;
import command.DeleteBookCommand;
import command.UpdateBookCommand;
import factory.LoanManager;
import factory.Notification;
import iterator.LibraryIterator;
import model.Book;
import registry.LibraryCatalog;

public class LibraryFacade {

    private final LibraryCatalog catalog;
    private final LoanManager loanManager;

    public LibraryFacade() {
        this.catalog = LibraryCatalog.getInstance();
        this.loanManager = new LoanManager();
        this.loanManager.registerObserver(new Notification());
    }

    public void borrowBook(String isbn, String userId) {
        loanManager.borrowBook(isbn, userId);
    }

    public void checkOverdues() {
        loanManager.checkOverdueBooks();
    }


// ---------- BOOK MANAGEMENT ----------

    public void addBook(String title, String author, String isbn, String category) {
        Book book = new Book(title, author, isbn, category);
        Command command = new AddBookCommand(book);
        command.execute();
    }

    public void updateBook(String isbn, String title, String author, String category) {
        Book updatedBook = new Book(title, author, isbn, category);
        Command command = new UpdateBookCommand(isbn, updatedBook);
        command.execute();
    }

    public void deleteBook(String isbn) {
        Command command = new DeleteBookCommand(isbn);
        command.execute();
    }

    public void viewBooks() {
        System.out.println("---- BOOK CATALOG ----");
        catalog.getBooks()
                .forEach(book -> System.out.println(book.getDetails()));
    }

    public void viewBooksUsingIterator() {
        System.out.println("---- BOOK LIST (Iterator) ----");

        LibraryIterator<Book> iterator = catalog.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getDetails());
        }
    }

}

