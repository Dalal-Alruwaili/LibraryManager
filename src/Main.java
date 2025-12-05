import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, String isbn) {
        if (title.isBlank() || author.isBlank() || isbn.isBlank()) {
            System.out.println("Error: Title, Author, and ISBN cannot be empty. Book not added.");
            return;
        }
        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully.");
    }

    public void deleteBookByIndexOrISBN() {
        if (books.isEmpty()) {
            System.out.println("No books available to delete.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete by: 1) Index  2) ISBN");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                showBooksWithIndex();
                System.out.print("Enter index of the book to delete: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                if (index >= 0 && index < books.size()) {
                    System.out.println("\nDeleting: " + books.get(index));
                    books.remove(index);
                    System.out.println("Book deleted successfully.");
                } else {
                    System.out.println("Invalid index. No book deleted.");
                }
                break;

            case 2:
                System.out.print("Enter ISBN of the book to delete: ");
                String isbn = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getISBN().equalsIgnoreCase(isbn)) {
                        System.out.println("\nDeleting: " + books.get(i));
                        books.remove(i);
                        System.out.println("Book deleted successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("No book found with ISBN: " + isbn);
                }
                break;

            default:
                System.out.println("Invalid choice. No book deleted.");
        }
    }

    public void editBook(int index, String newTitle, String newAuthor, String newIsbn) {
        if (index >= 0 && index < books.size()) {
            Book book = books.get(index);
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setISBN(newIsbn);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Invalid index. Book not updated.");
        }
    }

    public void showBooksWithIndex() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n---- Books List ----");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + ": " + books.get(i));
        }
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n---- Library Books ----");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + ". " + books.get(i));
        }
    }
    public void searchBook(String keyword) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        boolean found = false;
        System.out.println("\n---- Search Results ----");
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getISBN().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found matching: " + keyword);
        }
    }
    public void sortBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available to sort.");
            return;
        }

        books.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Books sorted alphabetically by title.");
    }
}
