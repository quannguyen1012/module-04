package com.cg.productmanager.service;

import com.cg.productmanager.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{

    private static final Map<Integer, Product> products;

    private static int autoIncrement = 0;

    static {
        products = new HashMap<>();
        products.put(autoIncrement++, new Product(1, "iphone",  "yellow",false,"1000"));
        products.put(autoIncrement++, new Product(2, "samsung", "red",false,"1200"));
        products.put(autoIncrement++, new Product(3, "xiaomi", "Violet",false,"600"));
        products.put(autoIncrement++, new Product(4, "nokia", "green",false,"800"));
        products.put(autoIncrement++, new Product(5, "iphone14" , "blue",false,"1500"));
        products.put(autoIncrement++, new Product(6, "oppo" , "grey",false,"1100"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
