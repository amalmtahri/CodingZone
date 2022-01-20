package com.coding.codingzone.dao;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {

    public abstract List<T> all();
    public abstract T find(String id);
    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void delete(String id);

}
