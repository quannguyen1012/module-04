package com.cg.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Employee {

    @NotEmpty(message = "Id may not be empty")
    private String id;

    @NotBlank(message = "Name is blank")
    @NotEmpty(message = "Name is empty")
    private String name;

    @NotBlank(message = "Contact number is blank")
    @NotEmpty(message = "Contact number is empty")
    private String contactNumber;

    public Employee() {
    }

    public Employee(String id, String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
