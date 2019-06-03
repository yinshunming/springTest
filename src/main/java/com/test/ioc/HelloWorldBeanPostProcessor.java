package com.test.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HelloWorldBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof HelloWorld) {
            HelloWorld helloWorld = (HelloWorld)bean;
            System.out.println("postProcessBeforeInitialization");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof  HelloWorld) {
            HelloWorld helloWorld = (HelloWorld)bean;
            helloWorld.setMessage("Hello Earth!");
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
    }
}
