package com.test.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("穿衣服!");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("脱衣服!");
    }

    public void beforeDo() {
        System.out.println("开始准备");
    }

    public void afterDo() {
        System.out.println("收拾下");
    }
}
