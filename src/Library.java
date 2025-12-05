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
}
