package factory;




import model.Loan;
import observer.Observer;
import observer.Subject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanManager implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // ---- Loan processing ----
    public void borrowBook(String bookIsbn, String userId) {
        Loan loan = new Loan(bookIsbn, userId, LocalDate.now().plusDays(7));
        loans.add(loan);

        notifyObservers(
                "Book ISBN " + bookIsbn +
                        " borrowed by User " + userId +
                        ". Due date: " + loan.getDueDate()
        );
    }

    public void checkOverdueBooks() {
        for (Loan loan : loans) {
            if (loan.isOverdue()) {
                notifyObservers(
                        "⚠ OVERDUE: Book ISBN " + loan.getBookIsbn() +
                                " was due on " + loan.getDueDate()
                );
            }
        }
    }
}

