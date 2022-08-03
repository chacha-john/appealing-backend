package com.chachaup.appealing.interfaces;

import com.chachaup.appealing.models.Book;
import org.sql2o.Connection;

import java.util.List;

public interface IBook {
    // CRUD operations

    // Create
    void createBook(Connection connection, Book book);

    // Read
    Book getBook(Connection connection, int id);
    List<Book> getAllBooks(Connection connection);
    List<Book> getBooksByAuthor(Connection connection, String author);
    List<Book> getBooksByName(Connection connection, String name);
    List<Book> getBooksByPrice(Connection connection, int price);


    // Update
    void updateBook(Connection connection, Book book);

    // Delete
    void deleteBook(Connection connection, int id);
}
