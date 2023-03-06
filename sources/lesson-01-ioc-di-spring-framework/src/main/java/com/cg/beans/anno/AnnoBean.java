package com.cg.beans.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoBean {

    @Bean
    public Developer developer() {
        Developer developer = new Developer();
        developer.setId(3);
        developer.setName("tin@gmail.com");
        developer.setMajor("FullStack");
        return developer;
    }
}
