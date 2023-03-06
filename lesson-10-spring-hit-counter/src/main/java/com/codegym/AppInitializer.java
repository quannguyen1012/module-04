package com.codegym;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
//        return new Class[] {};
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
//        return new String[] {"/"};

        String[] servletMappings = new String[2];
        servletMappings[0] = "/";
        servletMappings[1] = "/home";
        return servletMappings;
    }
}
