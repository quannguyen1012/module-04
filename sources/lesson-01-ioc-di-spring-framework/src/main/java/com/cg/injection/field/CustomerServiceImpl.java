package com.cg.injection.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private OrderService orderService;

    @Override
    public String eat() {
        return orderService.orderFood();
    }

    @Override
    public String drink() {
        return "Recommended drinks...";
    }

}
