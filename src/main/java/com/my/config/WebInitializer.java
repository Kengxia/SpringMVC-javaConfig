package com.my.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author 华安  mashuai_bj@si-tech.com.cn
 * @Title:
 * @Date: Create in 16:52 2018/7/18
 * @Description:
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class,MyBatisConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {CharacterEncodingFilter()};
    }

    private Filter CharacterEncodingFilter(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[0];
//    }
}