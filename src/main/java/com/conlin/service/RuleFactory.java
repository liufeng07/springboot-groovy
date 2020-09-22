package com.conlin.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 反射生成接口工厂
 */
public class RuleFactory {
    private static volatile RuleFactory singleton = null;

    private RuleFactory() {
    }

    public static RuleFactory getInstance() {
        // 第一次校验singleton是否为空
        if (singleton == null) {
            synchronized (RuleFactory.class) {
                // 第二次校验singleton是否为空
                if (singleton == null) {
                    singleton = new RuleFactory();
                }
            }
        }
        return singleton;
    }

    public List<IRule> getRuleList() throws Exception {
        //调用普通的JAVA实现做对比
        List<IRule> rules = new ArrayList<>();
        //直接读取Groovy文件生成IRule实现
        IRule groovyFile = GroovyFactory.getInstance()
                .getIRuleFromPackage("src/main/resources/groovy/GroovyFileRule.groovy");
        rules.add(groovyFile);
        return rules;
    }

    public List<IRule2> getRuleList2() throws Exception {
        List<IRule2> rules = new ArrayList<>();
        //直接读取Groovy文件生成IRule2实现
        IRule2 groovyFile = GroovyFactory.getInstance()
                .getIRuleFromPackage("src/main/resources/groovy/GroovyFileRule2.groovy");
        rules.add(groovyFile);
        return rules;
    }
}
