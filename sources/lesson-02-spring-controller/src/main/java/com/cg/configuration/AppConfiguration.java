package com.cg.configuration;

import com.cg.repository.ProductRepository;
import com.cg.repository.ProductRepositoryImpl;
import com.cg.service.ProductService;
import com.cg.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }
}
