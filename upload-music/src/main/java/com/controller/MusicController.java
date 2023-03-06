package com.controller;

import com.model.Music;
import com.model.MusicForm;
import com.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("musics",musicService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm",new MusicForm());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("musicForm") MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMusic().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getId(), musicForm.getName(),
                musicForm.getMusician(),musicForm.getCategory(), fileName);
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
