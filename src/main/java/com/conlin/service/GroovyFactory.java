package com.conlin.service;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.File;
import java.net.URL;

public class GroovyFactory implements ApplicationContextAware {
    private static GroovyFactory groovyFactory = new GroovyFactory();
    private GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

    public static GroovyFactory getInstance() {
        return groovyFactory;
    }

    /**
     * 根据groovy文件路径生成IRule的实现
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public IRule getIRuleFromPackage(String filePath) throws Exception {
        ClassLoader parent = this.getClass().getClassLoader();
        groovyClassLoader = new GroovyClassLoader(parent);
        Class<?> clazz = groovyClassLoader.parseClass(new File(filePath));
        if (clazz != null) {
            Object instance = clazz.newInstance();
            if (instance != null) {
                if (instance instanceof IRule) {
                    return (IRule) instance;
                }
            }
        }
        throw new IllegalArgumentException("读取groovy文件异常");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 只有这个对象才能注册bean到spring容器
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        // 因为spring会自动将xml解析成BeanDefinition对象然后进行实例化，这里我们没有用xml，所以自己定义BeanDefinition
        // 这些信息跟spring配置文件的方式差不多，只不过有些东西lang:groovy标签帮我们完成了
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClassName("org.springframework.scripting.groovy.GroovyScriptFactory");
        final String refreshCheckDelay = "org.springframework.scripting.support.ScriptFactoryPostProcessor.refreshCheckDelay";
        final String language = "org.springframework.scripting.support.ScriptFactoryPostProcessor.language";
        // 刷新时间
        bd.setAttribute(refreshCheckDelay, 500);
        // 语言脚本
        bd.setAttribute(language, "groovy");
        // 文件目录
        bd.getConstructorArgumentValues().addIndexedArgumentValue(0, "file:src/main/resources/groovy/GroovyFileRule.groovy");
        // 注册到spring容器
        beanFactory.registerBeanDefinition("IRule", bd);
    }
}
