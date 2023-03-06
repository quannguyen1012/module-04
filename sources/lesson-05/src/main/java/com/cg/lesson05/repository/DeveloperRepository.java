package com.cg.lesson05.repository;

import com.cg.lesson05.model.Developer;

import java.util.List;


public interface DeveloperRepository {

    public List<Developer> getAll();

    public void save(Developer developer);

    public Developer get(int id);

    public void delete(int id);
}
