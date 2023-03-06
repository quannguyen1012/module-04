package com.cg.injection.field;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Override
    public String orderFood() {
        return "Food ordering...";
    }
}
