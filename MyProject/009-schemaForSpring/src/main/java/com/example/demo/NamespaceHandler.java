package com.example.demo;

import org.springframework.beans.factory.config.BeanDefinition;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface NamespaceHandler {
  void init();
  BeanDefinition parse(Element element, ParserContext parserContext);
  BeanDefinitionHolder decorate(Node source, BeanDefinitionHolder definition, ParserContext parserContext);
}
