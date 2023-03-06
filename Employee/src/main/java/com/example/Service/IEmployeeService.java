package com.example.Service;

import com.example.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    void save(Employee employee);
    void remove(Long id);
    List<Employee> findAllByBranch(Long id);
    List<Employee> findByLastNameOrderBySeatNumberAsc(String name);

}
