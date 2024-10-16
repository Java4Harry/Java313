package org.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public Baby sonBean(){
        return new Son();
    }

    @Bean
    public Father fatherBean(){
        return new Father(sonBean());
    }
}
