package com.conlin.service;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;

import java.io.File;
import java.net.URL;

public class GroovyFactory {
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
}
