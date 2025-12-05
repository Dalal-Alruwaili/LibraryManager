import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== Library Manager =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    library.addBook(title, author, isbn);
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}