package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("customers/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView create(@ModelAttribute Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }

    @GetMapping("delete-{id}")
    public ModelAndView showViewDelete(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/customers/delete");
        modelAndView.addObject("customer", customerService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Customer customer){
        customerService.delete(customer.getId());
        return "redirect:/";
    }

//    @GetMapping("edit/{id}")
//    public ModelAndView showViewEdit@PathVariable Long id){
//        ModelAndView modelAndView = new ModelAndView("/customers/delete");
//        modelAndView.addObject("customer", customerService.findOne(id));
//        return modelAndView;
//    }
//
//    @PostMapping("delete")
//    public ModelAndView edit(@ModelAttribute Customer customer){
//        customerService.delete(customer);
//        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
//        return modelAndView;
//    }



}
