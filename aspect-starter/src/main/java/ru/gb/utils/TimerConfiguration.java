package ru.gb.utils;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimerConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TimeAspect timeAspect() {
        System.out.print("куку");
        return new TimeAspect();
    }
}
