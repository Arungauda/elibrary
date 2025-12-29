package model;


import java.time.LocalDate;

public class Loan {

    private final String bookIsbn;
    private final String userId;
    private final LocalDate dueDate;
    private boolean returned;

    public Loan(String bookIsbn, String userId, LocalDate dueDate) {
        this.bookIsbn = bookIsbn;
        this.userId = userId;
        this.dueDate = dueDate;
        this.returned = false;
    }

    public boolean isOverdue() {
        return !returned && LocalDate.now().isAfter(dueDate);
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void markReturned() {
        this.returned = true;
    }
}

