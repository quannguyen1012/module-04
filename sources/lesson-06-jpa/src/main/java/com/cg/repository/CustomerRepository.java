package com.cg.repository;

import com.cg.model.Customer;

import java.util.List;

public interface CustomerRepository{
    List<Customer> findAll();


    void save(Customer customer);
}
