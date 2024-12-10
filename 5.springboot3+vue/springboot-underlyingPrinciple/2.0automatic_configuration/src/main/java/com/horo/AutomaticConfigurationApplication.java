package com.horo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class AutomaticConfigurationApplication
{
    public static void main( String[] args )
    {
        ApplicationContext context = SpringApplication.run(AutomaticConfigurationApplication.class, args);
        System.out.println(context.getBean("dispatcherServlet"));
    }
}
