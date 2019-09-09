package com.example.demo;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class KiritoNamespaceHandler extends NamespaceHandlerSupport {

  @Override
  public void init() {
    super.registerBeanDefinitionParser("application",
        new KiritoBeanDefinitionParser(ApplicationConfig.class));
    super
        .registerBeanDefinitionParser("service", new KiritoBeanDefinitionParser(ServiceBean.class));
  }
}
