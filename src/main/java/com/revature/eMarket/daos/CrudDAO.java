package com.revature.eMarket.daos;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<T> {
    void save(T obj);
    void update(String id);

    void delete(String id);

    Optional<T> findById(String id);

    List<T> findAll();
}