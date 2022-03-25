package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface CrudService <T,ID> {
    T save(T obeject);
    List<T> findALL();
    T findByID(ID id);
    void delete(T object);
    void deleteById(ID id);
}
