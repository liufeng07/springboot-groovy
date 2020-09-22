package com.conlin.service;

import groovy.lang.GroovyClassLoader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.io.File;
import java.io.FileFilter;

/**
 * 通过实现ApplicationContextAware接口，拿到ApplicationContext
 */
public class GroovyFactory implements ApplicationContextAware {

    private String directory;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    private static GroovyFactory groovyFactory = new GroovyFactory();

    public static GroovyFactory getInstance() {
        return groovyFactory;
    }

    private GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

    /**
     * 根据groovy文件路径生成IRule的实现
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public <T> T getIRuleFromPackage(String filePath) throws Exception {
        ClassLoader parent = this.getClass().getClassLoader();
        groovyClassLoader = new GroovyClassLoader(parent);
        Class<?> clazz = groovyClassLoader.parseClass(new File(filePath));
        if (clazz != null) {
            Object instance = clazz.newInstance();
            if (instance != null) {
                if (instance instanceof IRule) {
                    return (T) instance;
                }
                if (instance instanceof IRule2) {
                    return (T) instance;
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

        final String refreshCheckDelay = "org.springframework.scripting.support.ScriptFactoryPostProcessor.refreshCheckDelay";
        final String language = "org.springframework.scripting.support.ScriptFactoryPostProcessor.language";

        String realDirectory = "/Users/liufeng/code/Conlin/springboot-groovy/target/classes/groovy";
        //String realDirectory = Thread.currentThread().getContextClassLoader().getResource(directory).getFile();
        File root = new File(Thread.currentThread().getContextClassLoader().getResource(".").getFile());
        //文件过滤
        File[] files = new File(realDirectory).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".groovy") ? true : false;
            }
        });

        for (File file : files) {
            System.out.println(file.getPath());
            System.out.println(root.getPath());
            System.out.println(file.getPath().replace(root.getPath(), ""));
            System.out.println(file.getName().replace(".groovy", ""));
            GenericBeanDefinition bd = new GenericBeanDefinition();
            bd.setBeanClassName("org.springframework.scripting.groovy.GroovyScriptFactory");
            // 刷新时间
            bd.setAttribute(refreshCheckDelay, 500);
            // 语言脚本
            bd.setAttribute(language, "groovy");

//             //文件目录
//            bd.getConstructorArgumentValues().addIndexedArgumentValue(0, "file:src/main/resources/groovy/GroovyFileRule.groovy");
//             //注册到spring容器
//            beanFactory.registerBeanDefinition("IRule", bd);


            // 文件目录
            bd.getConstructorArgumentValues().addIndexedArgumentValue(0, file.getPath().replace(root.getPath(), ""));
            // 注册到spring容器
            beanFactory.registerBeanDefinition(file.getName().replace(".groovy", ""), bd);
        }
    }
}
