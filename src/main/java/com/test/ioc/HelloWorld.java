package com.test.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class HelloWorld implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String name;
    private String message;
    private BeanFactory beanFactory;

    public HelloWorld() {
        System.out.println("构造函数");
    }

    public void setMessage(String message){
        this.message  = message;
        System.out.println("set 属性");
    }
    public void getMessage(){
        System.out.println("Bean name is : " + name + " and your Message : " + message);
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println("beanNameAware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet");
    }

    public void initMethod() throws Exception {
        System.out.println("执行配置的init-method");
    }

    public void destroyMethod() throws Exception {
        System.out.println("执行配置的destroy-method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destory");
    }
}