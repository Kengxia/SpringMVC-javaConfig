package com.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author 华安  mashuai_bj@si-tech.com.cn
 * @Title:
 * @Date: Create in 17:03 2018/7/18
 * @Description:
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.my.work")
public class WebConfig extends WebMvcConfigurerAdapter {

        @Bean
        public ViewResolver viewResolver() { //配置JSP视图解析器
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("/WEB-INF/views/");
            resolver.setSuffix(".jsp");
            //可以在JSP页面中通过${}访问beans
            resolver.setExposeContextBeansAsAttributes(true);
            return resolver;
        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable(); //配置静态文件处理
        }
}