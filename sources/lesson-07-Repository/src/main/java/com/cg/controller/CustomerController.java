package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.impl.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    private ICustomerService customerService;

    public CustomerController(ICustomerService customerService ){
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search,
                                      @RequestParam("page") Optional<Integer> p){
        Page<Customer> customers;
        Pageable firstPageWithTwoElements = PageRequest.of(p.orElse(0), 2);
        if(search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(search.get(), firstPageWithTwoElements);
        } else {
            customers = customerService.findAll(firstPageWithTwoElements);
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
