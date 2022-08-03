package com.chachaup.appealing.dao;

import com.chachaup.appealing.interfaces.IBook;
import com.chachaup.appealing.models.Book;
import org.sql2o.Connection;

import java.util.List;

public class BookDao implements IBook {

    @Override
    public void createBook(Connection connection, Book book) {
        try {
            String query = "INSERT INTO books (bookName, bookAuthor, bookDescription, bookPrice, bookImg) VALUES (:bookName, :bookAuthor, :bookDescription, :bookPrice, :bookImg)";
            int id = (int) connection.createQuery(query, true)
                    .bind(book)
                    .executeUpdate()
                    .getKey();
            book.setId(id);
        } catch (Exception ex) {
            throw new RuntimeException("Error creating book: " + ex.getMessage());
        }

    }

    @Override
    public Book getBook(Connection connection, int id) {
        try {
            String query = "SELECT * FROM books WHERE id = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Book.class);
        } catch (Exception ex) {
            throw new RuntimeException("Error getting book: " + ex.getMessage());
        }
    }

    @Override
    public List<Book> getAllBooks(Connection connection) {
        try {
            String query = "SELECT * FROM books";
            return connection.createQuery(query)
                    .executeAndFetch(Book.class);
        } catch (Exception ex) {
            throw new RuntimeException("Error getting all books: " + ex.getMessage());
        }
    }

    @Override
    public List<Book> getBooksByAuthor(Connection connection, String author) {
        try {
            String query = "SELECT * FROM books WHERE bookAuthor = :author";
            return connection.createQuery(query)
                    .addParameter("author", author)
                    .executeAndFetch(Book.class);
        } catch (Exception ex) {
            throw new RuntimeException("Error getting books by author: " + ex.getMessage());
        }
    }

    @Override
    public List<Book> getBooksByName(Connection connection, String name) {
        try {
            String query = "SELECT * FROM books WHERE bookName = :name";
            return connection.createQuery(query)
                    .addParameter("name", name)
                    .executeAndFetch(Book.class);
        } catch (Exception ex) {
            throw new RuntimeException("Error getting books by name: " + ex.getMessage());
        }
    }

    @Override
    public List<Book> getBooksByPrice(Connection connection, int price) {
        try {
            String query = "SELECT * FROM books WHERE bookPrice = :price";
            return connection.createQuery(query)
                    .addParameter("price", price)
                    .executeAndFetch(Book.class);
        } catch (Exception ex) {
            throw new RuntimeException("Error getting books by price: " + ex.getMessage());
        }
    }

    @Override
    public void updateBook(Connection connection, Book book) {
        try {
            String query = "UPDATE books SET bookName = :bookName, bookAuthor = :bookAuthor, bookDescription = :bookDescription, bookPrice = :bookPrice, bookImg = :bookImg WHERE id = :id";
            connection.createQuery(query)
                    .bind(book)
                    .executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Error updating book: " + ex.getMessage());
        }
    }

    @Override
    public void deleteBook(Connection connection, int id) {
        try {
            String query = "DELETE FROM books WHERE id = :id";
            connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Error deleting book: " + ex.getMessage());
        }
    }
}
