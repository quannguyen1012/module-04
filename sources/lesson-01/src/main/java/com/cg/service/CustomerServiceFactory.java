package com.cg.service;

import com.cg.service.impl.SimpleCustomerServiceImpl;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}
