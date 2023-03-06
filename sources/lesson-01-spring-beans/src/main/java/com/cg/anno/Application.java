package com.cg.anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBeans.class);

        Developer fs = (Developer) context.getBean("developer");
        System.out.println(fs);

        context.close();
    }
}