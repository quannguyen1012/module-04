package com.controller;

import com.model.Customer;
import com.service.CustomerServiceImpl;
import com.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    private final ICustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String create(Customer customer){
        customer.setId((int) (Math.random() * 100));
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String editForm(Model model, @PathVariable Integer id){
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("edit")
    public String edit(Customer customer){
        customerService.update(customer.getId(), customer);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteForm(Model model, @PathVariable Integer id){
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }

    @PostMapping("delete")
    public String delete(Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/";
    }

    @GetMapping("view/{id}")
    public String view(Model model, @PathVariable Integer id){
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }
}
