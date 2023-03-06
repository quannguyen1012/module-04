package com.example.Service;

import com.example.Repository.EmployeeRepository;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByBranch(Long  id) {
        return employeeRepository.findAllByBranch(id);
    }

    @Override
    public List<Employee> findByLastNameOrderBySeatNumberAsc(String name) {
        return employeeRepository.findByOrderByAgeAsc();
    }
}
