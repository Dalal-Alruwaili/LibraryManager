public class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return isbn; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setISBN(String isbn) { this.isbn = isbn; }

    @Override
    public String toString() {
        return "Title: " + title + " | Author: " + author + " | ISBN: " + isbn;
    }
}
