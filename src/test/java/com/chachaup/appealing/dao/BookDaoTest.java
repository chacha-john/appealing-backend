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
        Book book = new Book("Book 1", "Author 1", "Description 1", 1, https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png);
        IBook bookDao = new BookDao();
        bookDao.createBook(con,book);
        assertEquals(1, bookDao.getAllBooks(con).size());
    }

    @Test
    void getBook() {
        IBook bookDao = new BookDao();
        Book book = bookDao.getBook(con, 1);
        assertEquals("Book 1", book.getBookName());
    }

    @Test
    void getAllBooks() {
        IBook bookDao = new BookDao();
        assertEquals(3, bookDao.getAllBooks(con).size());
    }

    @Test
    void getBooksByAuthor() {
        IBook bookDao = new BookDao();
        assertEquals(2, bookDao.getBooksByAuthor(con, "Author 1").size());
    }

    @Test
    void getBooksByName() {
        IBook bookDao = new BookDao();
        assertEquals(2, bookDao.getBooksByName(con, "Book 1").size());
    }

    @Test
    void getBooksByPrice() {
        IBook bookDao = new BookDao();
        assertEquals(2, bookDao.getBooksByPrice(con, 1).size());
    }

    @Test
    void updateBook() {
        IBook bookDao = new BookDao();
        Book book = bookDao.getBook(con, 1);
        book.setBookName("Book 2");
        bookDao.updateBook(con, book);
        assertEquals("Book 2", bookDao.getBook(con, 1).getBookName());
    }

    @Test
    void deleteBook() {
        IBook bookDao = new BookDao();
        bookDao.deleteBook(con, 1);
        assertEquals(2, bookDao.getAllBooks(con).size());
    }
}