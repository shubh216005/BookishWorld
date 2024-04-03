package Project;

import java.util.ArrayList;
import java.util.List;

public class BookClub {
    private String name;
    private List<Book> books;
    private List<String> members;

    // Constructor
    public BookClub(String name) {
        this.name = name;
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add book to club's library
    public void addBook(Book book) {
        books.add(book);
    }

    // Register member to the club
    public void registerMember(String member) {
        members.add(member);
    }

    // Get all books in the club's library
    public List<Book> getBooks() {
        return books;
    }

    // Get all members of the club
    public List<String> getMembers() {
        return members;
    }
}
