package com.mybookmaker.pl.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class[] {DBConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
/*
        return new Class[] {DemoAppConfig.class};*/
    return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}

