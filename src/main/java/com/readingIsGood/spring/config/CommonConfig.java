package com.readingIsGood.spring.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.readingIsGood")
@EnableJpaRepositories(value = "com.readingIsGood.repository")
@EntityScan(value = "com.readingIsGood.entity")
@EnableWebMvc
public class CommonConfig {
}
