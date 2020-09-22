package com.conlin.controller;

import com.conlin.service.*;
import com.conlin.units.SpringApplicationContextUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * java 方式通过 GroovyClassLoader 来加载实现
 * spring 方式需要通过接口实现，才能调用到实现类。
 */
@RestController
@Lazy
public class GroovyController {


    /**
     * java 方式 GroovyClassLoader 来加载实现
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/test")
    public String test() throws Exception {
        List<IRule> list = RuleFactory.getInstance().getRuleList();
        for (IRule item : list) {
            item.printInfo();
        }
        List<IRule2> list2 = RuleFactory.getInstance().getRuleList2();
        for (IRule2 item : list2) {
            item.query();
        }
        return "SUCCESS test";
    }


//    @Resource(name = "GroovyFileRule")
//    private IRule iRule;

    /**
     * spring 管理groovy bean来实现
     *
     * @return
     */
    @RequestMapping(value = "/test2")
    public String test2() {
        IRule groovyRule = (IRule) SpringApplicationContextUtil.getBean("GroovyFileRule");
        groovyRule.printInfo();
        return "SUCCESS test2";
    }


//    @Resource
//    private IRule iRule;

//    /**
//     * spring 接口方式来实现
//     * @return
//     */
//    @RequestMapping("/test3")
//    public String test3() {
//        System.out.println("----test3------");
//      iRule.printInfo();
//      return "test3";
//    }
}
