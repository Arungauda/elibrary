package registry;

import iterator.BookIterator;
import iterator.LibraryIterator;
import model.Book;
import java.util.*;

public class LibraryCatalog {
    private static LibraryCatalog instance;
    private final Map<String, Book> booksMap;

    private LibraryCatalog() {
        this.booksMap = new HashMap<>();
    }

    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addBook(Book book) {
        booksMap.put(book.getIsbn(), book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(booksMap.values());
    }
    
    public Book getBookByIsbn(String isbn) {
        return booksMap.get(isbn);
    }

    public void updateBook(String isbn, Book updatedBook) {
        if (!booksMap.containsKey(isbn)) {
            throw new RuntimeException("Book not found for update");
        }
        booksMap.put(isbn, updatedBook);
    }

    public void deleteBook(String isbn) {
        booksMap.remove(isbn);
    }

    public LibraryIterator<Book> createIterator() {
        return new BookIterator(new ArrayList<>(booksMap.values()));
    }

}
