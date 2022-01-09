package com.coding.codingzone.dao;

import java.sql.Connection;

public abstract class DAO<T> {
    //public Connection connect = Config.getInstance();

    public abstract T find(int id);
    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void delete(int id);
}
