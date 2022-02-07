package com.qa.marvelqa.service;

import java.util.List;

public interface ServiceCRUD <T> {

    T create(T t);

    List<T> getAll();

    T getById(Long id);

    T update(Long id, T t);

    boolean delete(Long id);
}
