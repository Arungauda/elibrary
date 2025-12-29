package decorator;


public class BookDecorator implements BookComponent {

    protected BookComponent book;

    public BookDecorator(BookComponent book) {
        this.book = book;
    }
    @Override
    public String getDetails() {
        return book.getDetails();
    }
}
