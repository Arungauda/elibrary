package decorator;

public class ReservableBook extends BookDecorator{

    private boolean reserved;

    public ReservableBook(BookComponent book) {
        super(book);
        this.reserved = false;
    }

    public void reserve() {
        this.reserved = true;
    }

    public void cancelReservation() {
        this.reserved = false;
    }

    @Override
    public String getDetails() {
        return super.getDetails() +
                ", Reservation: " + (reserved ? "RESERVED" : "NOT RESERVED");
    }
}
