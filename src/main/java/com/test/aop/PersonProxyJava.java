package com.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonProxyJava implements InvocationHandler {
    private Object delegate;


    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        System.out.println("Before Proxy");
        result = method.invoke(delegate, args);
        System.out.println("After Proxy");

        return result;
    }

    public static void main(String [] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        PersonProxyJava personProxy = new PersonProxyJava();
        IPerson iPerson = (IPerson)personProxy.bind(new Person());
        System.out.println(iPerson instanceof Proxy);
        iPerson.doSomething();
    }
}
