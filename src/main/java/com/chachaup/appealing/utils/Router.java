package com.chachaup.appealing.utils;

import com.chachaup.appealing.dao.BookDao;
import com.chachaup.appealing.database.DB;
import com.chachaup.appealing.database.DBImpl;
import com.chachaup.appealing.database.Seeder;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Router {
    private DB db = new DBImpl();
    private Connection con = db.connect();
    BookDao bookDao = new BookDao();


}
