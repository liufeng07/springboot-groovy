package com.conlin;

import com.conlin.service.IRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-groovy.xml")
class GroovyApplicationTests implements ApplicationContextAware {






//    @Test
//    public void helloTest() {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(
//                    System.in));
//            while (true) {
//                System.out.println("请输入任意字符：");
//                // 循环获取输入，每次有输入即进行一次调用
//                String line = reader.readLine();
//                Thread.sleep(1000);
//                if ("exit".equals(line)) {
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-groovy.xml");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    System.in));
            while (true) {
                System.out.println("请输入任意字符：");
                // 循环获取输入，每次有输入即进行一次调用
                String line = reader.readLine();
                if ("exit".equals(line)) {
                    break;
                }
                IRule bean = context.getBean(IRule.class);
                bean.printInfo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
