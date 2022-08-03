package com.chachaup.appealing.database;

import org.sql2o.Connection;

public class Seeder {
    public static void seed(Connection connection){
        try{
            String books = "CREATE TABLE IF NOT EXISTS books (\n" +
                    "  id SERIAL PRIMARY KEY,\n" +
                    "  name VARCHAR(255) NOT NULL,\n" +
                    "  author VARCHAR(255) NOT NULL,\n" +
                    "  description VARCHAR(255) NOT NULL,\n" +
                    "  price INTEGER NOT NULL,\n" +
                    "  img bytea NOT NULL\n" +
                    ");";
            connection.createQuery(books).executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void drop(Connection connection) {
        try {
            String books = "DROP TABLE IF EXISTS books;";
            connection.createQuery(books).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
