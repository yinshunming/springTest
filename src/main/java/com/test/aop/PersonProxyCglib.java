package com.test.aop;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PersonProxyCglib implements MethodInterceptor {
    private Object delegate;

    private PersonProxyCglib(Object o) {
        this.delegate = o;
    }
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before Proxy");
        Object reuslt = methodProxy.invoke(delegate, args);
        System.out.println("After Proxy");
        return reuslt;
    }

    public static Person getProxyInstance(Object o) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new PersonProxyCglib(o));
        return (Person) enhancer.create();
    }

    public static void main(String [] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, System.getProperty("user.dir"));
        Person person = PersonProxyCglib.getProxyInstance(new Person());
        person.doSomething();
    }
}
