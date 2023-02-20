package com.cydeo.service;

import java.util.List;

public interface CrudSerice<T, ID> {
    T save(T t);
    T findById(ID id);
    List<T> findAll();
    void delete(T t);
    void deleteById(ID id);
}
