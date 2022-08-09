package com.chachaup.appealing.utils;

import com.chachaup.appealing.dao.BookDao;
import com.chachaup.appealing.database.DB;
import com.chachaup.appealing.database.DBImpl;
import com.chachaup.appealing.database.Seeder;
import com.chachaup.appealing.interfaces.IBook;
import com.chachaup.appealing.models.Book;
import com.google.gson.Gson;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.Spark;

import static spark.Spark.*;
import static spark.route.HttpMethod.after;
import static spark.route.HttpMethod.get;

public class Router {
    public static void run(Connection connection){
        Gson gson = new Gson();
        staticFileLocation("/public");
        port(8085);

        post("/api/v1/book", "application/json", (req, res) -> {
            Book book = gson.fromJson(req.body(), Book.class);
            IBook bookDao = new BookDao();
            bookDao.createBook(connection, book);
            res.status(201);
            return gson.toJson(book);
        });

        Spark.get("/api/v1/books", "application/json", (req, res) -> {
            IBook bookDao = new BookDao();
            return gson.toJson(bookDao.getAllBooks(connection));
        });

        Spark.get("/api/v1/books/:id", "application/json", (req, res) -> {
            IBook bookDao = new BookDao();
            return gson.toJson(bookDao.getBook(connection, Integer.parseInt(req.params(":id"))));
        });

        patch("/api/v1/books/:id", "application/json", (req, res) -> {
            IBook bookDao = new BookDao();
            Book book = bookDao.getBook(connection, Integer.parseInt(req.params(":id")));
            Book book1 = gson.fromJson(req.body(), Book.class);
            bookDao.updateBook(connection, book.getId(), book1);
            res.status(200);
            return gson.toJson(book1);
        });

        delete("/api/v1/books/:id", "application/json", (req, res) -> {
            IBook bookDao = new BookDao();
            bookDao.deleteBook(connection, Integer.parseInt(req.params(":id")));
            res.status(200);
            return gson.toJson("Book deleted successfully");
        });
        //get books by author
        Spark.get("api/v1/books/authors/:author", "application/json", (req, res) -> {
            IBook bookDao = new BookDao();
            String author = req.queryParams(":author");
            res.status(200);
            return gson.toJson(bookDao.getBooksByAuthor(connection, author));
        });
        //get books by price
        Spark.get("api/v1/books/prices/:price", "application/json", (req, res) -> {
            IBook bookDao = new BookDao();
            int price = Integer.parseInt(req.params(":price"));
            res.status(200);
            return gson.toJson(bookDao.getBooksByPrice(connection, price));
        });
        //get books by name
        Spark.get("api/v1/books/names/:name", "application/json", (req, res) -> {
            IBook bookDao = new BookDao();
            String name = req.queryParams(":name");
            res.status(200);
            return gson.toJson(bookDao.getBooksByName(connection, name));
        });

        after((req, res) -> {
            res.type("application/json");
        });

    }



}
