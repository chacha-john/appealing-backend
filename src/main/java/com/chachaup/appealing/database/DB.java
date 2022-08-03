package com.chachaup.appealing.database;

import org.sql2o.Connection;

public abstract class DB {
    public abstract Connection connect();
    public abstract void disconnect(Connection connection);
}
