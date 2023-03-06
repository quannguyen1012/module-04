package com.cg.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public Developer developer() {
        Developer developer = new Developer();
        developer.setId(3);
        developer.setName("tin@gmail.com");
        developer.setMajor("FullStack");
        return developer;
    }
}