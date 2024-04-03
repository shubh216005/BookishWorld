package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class BookClubManagementSystem extends JFrame {
    private Connection connection;

    public BookClubManagementSystem(Connection connection) {
        this.connection = connection;
        initComponents();
    }

    private void initComponents() {
        // Create Swing components here (e.g., buttons, text fields, labels, etc.)
        // Add action listeners to handle user interactions (e.g., adding members/books)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); //to manually set the text location otherwise it goes to border
        setSize(600,700); //makes a frame
        setVisible(true);
        setTitle("Book Club Management System");
        setLocation(500,100);

        JLabel text = new JLabel("Name");
        text.setBounds(100,50,300,50);
        text.setFont(new Font("OSWALD", Font.BOLD,20));
        add(text);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(300,50,300,50);
        nameTextField.setFont(new Font("OSWALD", Font.BOLD,20));
        add(nameTextField);

        JLabel book = new JLabel("Book Name");
        book.setBounds(100,100,300,50);
        book.setFont(new Font("OSWALD", Font.BOLD,20));
        add(book);

        JTextField bookTextField = new JTextField();
        bookTextField.setBounds(300,100,300,50);
        bookTextField.setFont(new Font("OSWALD", Font.BOLD,20));
        add(bookTextField);

        JLabel genre = new JLabel("Select Genre");
        genre.setBounds(100,150,300,50);
        genre.setFont(new Font("OSWALD", Font.BOLD,20));
        add(genre);

        JRadioButton nonfiction = new JRadioButton("Non-Fiction");
        nonfiction.setBounds(300,150,300,30);
        add(nonfiction);

        JRadioButton fantasy = new JRadioButton("Fantasy");
        fantasy.setBounds(300,170,100,30);
        add(fantasy);

        JRadioButton thriller = new JRadioButton("Thriller");
        thriller.setBounds(300,190,100,30);
        add(thriller);

        JRadioButton romance = new JRadioButton("Romance");
        romance.setBounds(300,210,100,30);
        add(romance);

        JRadioButton horror = new JRadioButton("Horror");
        horror.setBounds(300,230,100,30);
        add(horror);

        ButtonGroup genree = new ButtonGroup(); //to allow only one radio button selection
        genree.add(nonfiction);
        genree.add(romance);
        genree.add(fantasy);
        genree.add(horror);
        genree.add(thriller);



    }

    public static void main(String[] args) {
        // Connect to the database
        Connection connection = null;
        try {
            // Replace the connection URL, username, and password with your own database credentials
            String url = "jdbc:mysql://localhost:3306/book_club_db";
            String username = "root";
            String password = "shubhangijha";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            System.exit(1);
        }

        // Create the main frame of the application
        Connection finalConnection = connection;
        SwingUtilities.invokeLater(() -> {
            BookClubManagementSystem app = new BookClubManagementSystem(finalConnection);
            app.setSize(600, 400); // Set your preferred size
            app.setVisible(true);
        });
    }
}