package com.service;

import com.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void update(Integer id, Customer customer);

    void remove(Integer id);
}
