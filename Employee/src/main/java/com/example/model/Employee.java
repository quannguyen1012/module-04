package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String employee_Code;
    private String name;
    private Integer age;
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "branch")
    private Branch branch;

    public Employee(Long id, String employee_Code, String name, Integer age, Integer salary, Branch branch) {
        this.id = id;
        this.employee_Code = employee_Code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }


    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_Code() {
        return employee_Code;
    }

    public void setEmployee_Code(String employee_Code) {
        this.employee_Code = employee_Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
