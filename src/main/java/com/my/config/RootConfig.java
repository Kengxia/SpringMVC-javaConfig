package com.my.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author 华安  mashuai_bj@si-tech.com.cn
 * @Title:
 * @Date: Create in 17:31 2018/7/18
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = {"com.my.config"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableTransactionManagement.class)})
public class RootConfig {
} 