package com.test;

import com.test.aop.IPerson;
import com.test.ioc.HelloWorld;
import net.sf.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, System.getProperty("user.dir"));
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        IPerson person = (IPerson)context.getBean("person");
        person.doSomething();
//        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
//        obj.getMessage();
//
//        ((ClassPathXmlApplicationContext) context).destroy();
    }
}
