package com.example.controller;

import com.example.Service.IBranchService;
import com.example.model. Branch;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BranchController {
    private final IBranchService branchService;

    public BranchController(IBranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/branch")
    public ModelAndView all(){
        ModelAndView modelAndView = new ModelAndView("branch/list");
        List<Branch> branches = branchService.findAll();
        modelAndView.addObject("branch", branches);
        return modelAndView;
    }

    @GetMapping("create/branch")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("branch/create");
        modelAndView.addObject("branch", new  Branch());
        return modelAndView;
    }

    @PostMapping("create/branch")
    public ModelAndView create(@ModelAttribute  Branch  branch){
        branchService.save( branch);
        ModelAndView modelAndView = new ModelAndView("branch/create");
        modelAndView.addObject("branch", new  Branch());
        modelAndView.addObject("massages", "Create successfully");
        return modelAndView;
    }

    @GetMapping("edit/branch/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("branch/edit");
        modelAndView.addObject("branch", branchService.findById(id));
        return modelAndView;
    }

    @PostMapping("edit/branch")
    public ModelAndView edit(@ModelAttribute  Branch  branch){
        branchService.save( branch);
        ModelAndView modelAndView = new ModelAndView("redirect:/branch");
        modelAndView.addObject("massages", "Create successfully");
        return modelAndView;
    }

    @GetMapping("delete/branch/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("branch/delete");
        modelAndView.addObject("branch", branchService.findById(id));
        return modelAndView;
    }

    @PostMapping("delete/branch")
    public ModelAndView delete(@ModelAttribute  Branch branch){
        branchService.remove( branch.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/branch");
        return modelAndView;
    }
}
