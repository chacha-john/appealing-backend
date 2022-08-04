package com.chachaup.appealing;

import com.chachaup.appealing.database.DBImpl;
import com.chachaup.appealing.database.Seeder;
import com.chachaup.appealing.utils.Router;
import org.sql2o.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = new DBImpl().connect();
        Seeder.seed(connection);
        new Router().run(connection);
    }
}