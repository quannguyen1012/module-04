package com.cg.injection.field;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("field-injection.xml");

        CustomerService customerService = (CustomerService) context.getBean("customerService");
        System.out.println(customerService.eat());

        context.close();
    }
}
