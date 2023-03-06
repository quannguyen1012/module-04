package com.cg.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private int id;

    private String name;

    private String description;

    private MultipartFile mp3;

    public ProductForm() {
    }

    public ProductForm(int id, String name, String description, MultipartFile mp3) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mp3 = mp3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getMp3() {
        return mp3;
    }

    public void setMp3(MultipartFile mp3) {
        this.mp3 = mp3;
    }
}
