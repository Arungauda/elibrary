package model;

import decorator.BookComponent;

import java.util.Objects;



public class Book  implements BookComponent {

    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean available = true;

    public Book(String title, String author, String isbn, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    @Override
    public String getDetails() {
        return "Title: " + title +
                ", Author: " + author +
                ", Category: " + category +
                ", ISBN: " + isbn +
                ", Status: " + (available ? "AVAILABLE" : "BORROWED");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return available == book.available && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn) && Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn, category, available);
    }
}
