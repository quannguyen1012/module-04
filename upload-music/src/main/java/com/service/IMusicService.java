package com.service;

import com.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    Music findById(Integer id);
    void save(Music music);
    Music update(Music music);
    void remove(Integer id);
}
