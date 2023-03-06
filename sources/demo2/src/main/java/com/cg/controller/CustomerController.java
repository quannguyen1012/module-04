package com.cg.controller;

import com.cg.model.Customer;
import com.cg.model.Province;
import com.cg.service.Customer.CustomerService;
import com.cg.service.Province.ProvinceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller

public class CustomerController {

    private final CustomerService customerService;

    private final ProvinceService provinceService;

    public CustomerController(CustomerService customerService, ProvinceService provinceService) {
        this.customerService = customerService;
        this.provinceService = provinceService;
    }

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("customers")
    public ModelAndView showList(@RequestParam("search")Optional<String> search,
                                 @RequestParam("page")Optional<Integer> p){
        Page<Customer> customers;
        Sort sort = Sort.by("firstName").ascending();
        Pageable firstPageWithFiveElement = PageRequest.of(p.orElse(0),5);

        if (search.isPresent()) {
            customers =  customerService.findAllByFirstNameContaining(search.get(), firstPageWithFiveElement);
        }else {
            customers =customerService.findAll(firstPageWithFiveElement);
        }
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("create-customer")
    public ModelAndView save(@ModelAttribute("customer")Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message","created successfully");
        return modelAndView;
    }

    @GetMapping("edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()){
            modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer",customer.get());
        }else {
            modelAndView = new ModelAndView("error.404");
        }
        return modelAndView;
    }

    @PostMapping("edit-customer")
    public ModelAndView edit(@ModelAttribute("customer")Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("massage", "Edited Successfully");
        return modelAndView;
    }

    @GetMapping("delete-customer/{id}")
    public ModelAndView showViewDelete(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()){
            modelAndView = new ModelAndView("customer/delete");
            modelAndView.addObject("customer",customer.get());
        }else {
            modelAndView = new ModelAndView("error.404");
        }
        return modelAndView;
    }

    @PostMapping("delete-customer")
    public String delete(@ModelAttribute("customer")Customer customer){
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
}
