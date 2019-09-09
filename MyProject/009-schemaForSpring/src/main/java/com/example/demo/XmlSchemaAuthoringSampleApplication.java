package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:kirito.xml"})
public class XmlSchemaAuthoringSampleApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication
        .run(XmlSchemaAuthoringSampleApplication.class, args);
    ServiceBean serviceBean = applicationContext.getBean(ServiceBean.class);
    System.out.println(serviceBean.getName());
    ApplicationConfig applicationConfig = applicationContext.getBean(ApplicationConfig.class);
    System.out.println(applicationConfig.getName());
  }
}
