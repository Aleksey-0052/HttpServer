package com.javarush.repository;

import com.javarush.model.Message;

import java.util.Map;

public interface Repository<T> {

    T findById(Long id);

    T saveOrUpdate(T entity);

    boolean delete(T entity);

    Map<Long, Message> getAll();
}
