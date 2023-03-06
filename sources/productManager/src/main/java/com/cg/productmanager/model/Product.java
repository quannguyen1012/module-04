package com.cg.productmanager.model;

public class Product {
    private Integer id;
    private String name;
    private String price;
    private String description;
    private boolean activate;

    public Product(Integer id, String name, String description, boolean activate,String price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.activate = activate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", activate=" + activate +
                '}';
    }
}