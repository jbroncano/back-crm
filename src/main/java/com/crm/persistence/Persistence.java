package com.crm.persistence;

import jakarta.ejb.Local;
import java.util.List;


@Local
public interface Persistence<T> {

    T save(T entity);

    T update(T entity);

    T findById(Object entityId);

    void delete(T entity);

    List<T> findAll();
    
}