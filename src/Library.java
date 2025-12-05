import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, String isbn) {
        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully.");
    }
    public void deleteBook(int index) {
        if (books.isEmpty()) {
            System.out.println("No books available to delete.");
            return;
        }

        if (index >= 0 && index < books.size()) {
            System.out.println("\nDeleting: " + books.get(index));
            books.remove(index);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Invalid index. No book deleted.");
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
}
