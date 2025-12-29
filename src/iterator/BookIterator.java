package iterator;


import model.Book;

import java.util.List;

public class BookIterator implements LibraryIterator<Book> {

    private final List<Book> books;
    private int position = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }


    @Override
    public Book next() {
        return books.get(position++);
    }
}

