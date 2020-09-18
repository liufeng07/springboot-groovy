package com.conlin.controller;

import com.conlin.service.IRule;
import com.conlin.service.RuleFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GroovyController {

    @Resource(name = "springGroovyRule")
    IRule springGroovyRule;

    @RequestMapping(value = "/test")
    public String test() throws Exception {
        List<IRule> list = RuleFactory.getInstance().getRuleList();
        list.add(springGroovyRule);
        for (IRule item : list) {
            item.printInfo();
        }
        return "SUCCESS";
    }
}
