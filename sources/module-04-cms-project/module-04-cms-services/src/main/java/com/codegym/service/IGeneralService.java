package com.codegym.service;


import com.codegym.dto.UserDto;
import com.codegym.entity.User;

import java.util.Optional;

public interface IGeneralService<T> {
//    Iterable<T> findAll();
//
//    Optional<T> findById(Integer id);

    User save(T t);

    void remove(Integer id);
}