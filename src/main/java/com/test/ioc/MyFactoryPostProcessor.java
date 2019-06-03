package com.test.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld",HelloWorld.class);
        System.out.println("postProcessBeanFactory");
//        helloWorld.setMessage("abcdef");

    }
}
