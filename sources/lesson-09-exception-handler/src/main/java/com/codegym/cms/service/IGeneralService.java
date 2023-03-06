package com.codegym.cms.service;

import com.codegym.cms.formatter.exception.DuplicateEmailException;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t) throws DuplicateEmailException;

    void remove(Long id);
}
