package com.example.Service;

import com.example.Repository.BranchRepo;
import com.example.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements IBranchService{
    @Autowired
    private BranchRepo branchRepo;

    @Override
    public List<Branch> findAll() {
        return branchRepo.findAll();
    }

    @Override
    public Branch findById(Long id) {
        return branchRepo.findById(id).get();
    }

    @Override
    public void save(Branch branch) {
        branchRepo.save(branch);
    }

    @Override
    public void remove(Long id) {
        branchRepo.deleteById(id);
    }
}
