package com.conlin.service.impl;

import com.conlin.service.IRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JAVA普通实现
 */
public class NormalJavaRuleImpl implements IRule {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public int getType() {
        return NORMAL_TYPE;
    }

    @Override
    public void printInfo() {
        log.info("这是正常的JAVA代码");
        printInfoHigh();
    }

    public void printInfoHigh() {
        log.info("这是正常的JAVA代码的代码");
    }
}
