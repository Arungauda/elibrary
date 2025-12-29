
import facade.LibraryFacade;
import java.util.Scanner;

public class Main {
    //   public static void main(String[] args) {
//        Book book = new Book(
//                "Clean Code",
//                "Robert C. Martin",
//                "ISBN-123",
//                "Programming"
//        );
//
//        ReservableBook reservableBook = new ReservableBook(book);
//        reservableBook.reserve();
//
//        System.out.println(reservableBook.getDetails());
//
//        Command addBook = new AddBookCommand(
//                new Book("Clean Code", "Robert C. Martin", "ISBN-123", "Programming")
//        );
//        addBook.execute();
//
//        Command deleteBook = new DeleteBookCommand("ISBN-123");
//        deleteBook.execute();
//
//        LibraryFacade library = new LibraryFacade();
//
//        library.addBook("Clean Code", "Robert C. Martin", "ISBN-123", "Programming");
//        library.viewBooks();
//        library.deleteBook("ISBN-123");
//
//        LibraryFacade libraryCheck = new LibraryFacade();
//
//        libraryCheck.borrowBook("ISBN-123", "U1");
//        libraryCheck.checkOverdues();
//
//        LibraryFacade libraryFacade = new LibraryFacade();
//
//        libraryFacade.addBook("Clean Code", "Robert C. Martin", "ISBN-123", "Programming");
//        libraryFacade.addBook("Effective Java", "Joshua Bloch", "ISBN-456", "Programming");
//        libraryFacade.viewBooksUsingIterator();


    public static void main(String[] args) {

        System.out.println("===== E-LIBRARY MANAGEMENT SYSTEM =====");

        LibraryFacade libraryFacade = new LibraryFacade();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. View Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Check Overdue Books");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                // ---------- ADD BOOK (Command + Facade) ----------
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();

                    libraryFacade.addBook(title, author, isbn, category);
                    break;

                // ---------- UPDATE BOOK (Command) ----------
                case 2:
                    System.out.print("Enter ISBN to Update: ");
                    String updateIsbn = scanner.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter New Author: ");
                    String newAuthor = scanner.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = scanner.nextLine();

                    libraryFacade.updateBook(updateIsbn, newTitle, newAuthor, newCategory);
                    break;

                // ---------- DELETE BOOK (Command) ----------
                case 3:
                    System.out.print("Enter ISBN to Delete: ");
                    String deleteIsbn = scanner.nextLine();

                    libraryFacade.deleteBook(deleteIsbn);
                    break;

                // ---------- VIEW BOOKS (Iterator) ----------
                case 4:
                    libraryFacade.viewBooksUsingIterator();
                    break;

                // ---------- BORROW BOOK (Observer + Adapter) ----------
                case 5:
                    System.out.print("Enter Book ISBN: ");
                    String borrowIsbn = scanner.nextLine();

                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();

                    libraryFacade.borrowBook(borrowIsbn, userId);
                    break;

                // ---------- CHECK OVERDUE (Observer) ----------
                case 6:
                    libraryFacade.checkOverdues();
                    break;

                // ---------- EXIT ----------
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");


            }
        }
    }
}
