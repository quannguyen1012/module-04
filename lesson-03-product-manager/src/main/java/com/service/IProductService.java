package com.service;

import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void update(Integer id, Product product);

    void save(Product product);

    void remove(Integer id);
}
