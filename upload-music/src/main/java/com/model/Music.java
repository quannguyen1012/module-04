package com.model;

import javax.persistence.*;

@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String musician;
    private String Category;
    private String music;

    public Music() {
    }

    public Music(Integer id, String name, String musician, String category, String music) {
        this.id = id;
        this.name = name;
        this.musician = musician;
        Category = category;
        this.music = music;
    }

    public Music(String name, String musician, String category, String music) {
        this.name = name;
        this.musician = musician;
        Category = category;
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
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
