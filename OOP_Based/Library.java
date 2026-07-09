import java.util.*;
public class Library {

    static class Book {
        private String bookName;
        private String author;
        private String publisher;
        private String ISBN;
        public Book(String bookName, String author, String publisher, String ISBN) {
            this.bookName = bookName;
            this.author = author;
            this.publisher = publisher;
            this.ISBN = ISBN;
        }
        // public String getBookName() {
        //     return this.bookName;
        // }
        // public String getAuthor() {
        //     return this.author;
        // }
        // public String getPublisher() {
        //     return this.publisher;
        // }
        // public String getISBN() {
        //     return this.ISBN;
        // }
        @Override
        public String toString() {
            return "---------- "+ISBN+" ----------\n"
                               +"Book Name: "+bookName+"\n"
                               +"Author: "+author+"\n"
                               +"Publisher: "+publisher+"\n"
                               +"ISBN: "+ISBN+"\n";
        }
    }

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(Book b) {
        books.remove(b);
    }
    
    public void displayLibraryBooks() {
        for(Book b : books) {
            System.out.println(b);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Library city = new Library();
        Book b1 = new Book("Eleanor Oliphant is Completely Fine", "Gail Honeyman", "Harper Collins", "1234");
        Book b2 = new Book("Rag Darbari", "Lala Shukla", "Rajkamal", "5678");
        Book b3 = new Book("Jane Eyre", "Charlotte Bronte", "Penguin", "9012");
        city.addBook(b1);
        city.addBook(b2);
        city.addBook(b3);
        city.displayLibraryBooks();
        city.removeBook(b2);
        city.displayLibraryBooks();
    }
}
