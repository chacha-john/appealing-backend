package com.chachaup.appealing.dao;

import com.chachaup.appealing.database.DB;
import com.chachaup.appealing.database.DBImpl;
import com.chachaup.appealing.database.Seeder;
import com.chachaup.appealing.interfaces.IBook;
import com.chachaup.appealing.models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {
    private Connection con;
    private DB db;

    @BeforeEach
    void setUp() {
        db = new DBImpl();
        con = db.connect();
        Seeder.seed(con);
    }

    @AfterEach
    void tearDown() {
        db.disconnect(con);
        Seeder.drop(con);
    }

    @Test
    void createBook() {
        Book book = newBook();
        assertEquals(1, book.getId());
    }

    @Test
    void getBook() {
        IBook bookDao = new BookDao();
        Book book = newBook();
        assertEquals("the way of the superior man", book.getBookName());
    }

    @Test
    void getAllBooks() {
        IBook bookDao = new BookDao();
        Book book = newBook();
        Book book1 = newBook();
        Book book2 = newBook();
        assertEquals(3, bookDao.getAllBooks(con).size());
    }

    @Test
    void getBooksByAuthor() {
        IBook bookDao = new BookDao();
        Book book = newBook();
        Book book2 = newBook();
        assertEquals(2, bookDao.getBooksByAuthor(con, "David Deida").size());
    }

    @Test
    void getBooksByName() {
        IBook bookDao = new BookDao();
        Book book = newBook();
        Book book2 = newBook();
        assertEquals(2, bookDao.getBooksByName(con, "the way of the superior man").size());
    }

    @Test
    void getBooksByPrice() {
        IBook bookDao = new BookDao();
        Book book = newBook();
        Book book1 = newBook();
        assertEquals(2, bookDao.getBooksByPrice(con, 2000).size());
    }

    @Test
    void updateBook() {
        IBook bookDao = new BookDao();
        newBook();
        Book book = bookDao.getBook(con, 1);
        Book book1 = new Book("superior", "David Deida", "dodgy", 2000);
        bookDao.updateBook(con, book.getId(), book1);
        assertEquals("superior", bookDao.getBook(con, 1).getBookName());
    }

    @Test
    void deleteBook() {
        IBook bookDao = new BookDao();
        newBook();
        newBook();
        newBook();
        bookDao.deleteBook(con, 1);
        assertEquals(2, bookDao.getAllBooks(con).size());
    }

    //helper method to create a book
    private Book newBook() {
        Book book = new Book("the way of the superior man", "David Deida", "spiritual guide to mastering challenges of women, work, and sexual desire", 2000);
        IBook bookDao = new BookDao();
        bookDao.createBook(con, book);
        return book;
    }
}