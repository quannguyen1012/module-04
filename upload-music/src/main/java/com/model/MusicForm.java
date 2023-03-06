package com.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private Integer id;
    private String name;
    private String musician;
    private String category;
    private MultipartFile music;

    public MusicForm() {
    }

    public MusicForm(Integer id, String name, String musician, String category, MultipartFile music) {
        this.id = id;
        this.name = name;
        this.musician = musician;
        this.category = category;
        this.music = music;
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

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getMusic() {
        return music;
    }

    public void setMusic(MultipartFile music) {
        this.music = music;
    }
}
