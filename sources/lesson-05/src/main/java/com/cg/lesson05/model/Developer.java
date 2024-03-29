package com.cg.lesson05.model;


import java.io.Serializable;

public class Developer implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer salary;

    public Developer() {
        super();
    }

    public Developer(Integer id, String firstName, String lastName, Integer salary) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}