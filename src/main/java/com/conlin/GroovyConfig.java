package com.conlin;

import com.conlin.service.GroovyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scripting.support.ScriptFactoryPostProcessor;

/**
 * 注册相关groovy bean
 */
@Configuration
public class GroovyConfig {

    @Bean
    public GroovyFactory getGroovy()  {
        GroovyFactory groovyFactory = GroovyFactory.getInstance();
        groovyFactory.setDirectory("groovy");
        return groovyFactory;
    }

    @Bean
    public ScriptFactoryPostProcessor processor()  {
        return new ScriptFactoryPostProcessor();
    }
}
