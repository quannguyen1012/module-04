package com.example.Service;

import com.example.model.Branch;
import com.example.model.Employee;

import java.util.List;

public interface IBranchService {
    List<Branch> findAll();
    Branch findById(Long id);
    void save(Branch branch);
    void remove(Long id);

}
