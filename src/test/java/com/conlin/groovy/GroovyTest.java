package com.conlin.groovy;

import com.conlin.GroovyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class GroovyTest {

    @Test
    public void xmlBeanConfiguration() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(GroovyConfig.class);
        System.out.println("从容器获取Bean: " + applicationContext.getBean("groovyFactory"));
    }
}
