package com.example.controller;

import com.example.Service.IBranchService;
import com.example.Service.IEmployeeService;
import com.example.model.Branch;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final IBranchService branchService;

    public EmployeeController(IBranchService branchService, IEmployeeService employeeService) {
        this.branchService = branchService;
        this.employeeService = employeeService;
    }

    @ModelAttribute("branchs")
    public List<Branch> branches(){
        return branchService.findAll();
    }

    @GetMapping("/employees")
    public ModelAndView all(){
        ModelAndView modelAndView = new ModelAndView("em/list");
        List<Employee> employees = employeeService.findByLastNameOrderBySeatNumberAsc(String.valueOf(Sort.by(Sort.Direction.ASC, "age")));
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/employees/{id}")
    public ModelAndView allBranch(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("em/list");
        List<Employee> employees = employeeService.findAllByBranch(id);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("view/{id}")
    public ModelAndView view(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("em/view");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("create/Employee")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("em/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("create/Employee")
    public ModelAndView create(@ModelAttribute Employee employee){
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("em/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("massages", "Create successfully");
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("em/edit");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("edit/Employee")
    public ModelAndView edit(@ModelAttribute Employee employee){
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("redirect:/employees");
        modelAndView.addObject("massages", "Create successfully");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("em/delete");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("delete/Employee")
    public ModelAndView delete(@ModelAttribute Employee employee){
        employeeService.remove(employee.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/employees");
        return modelAndView;
    }
}
