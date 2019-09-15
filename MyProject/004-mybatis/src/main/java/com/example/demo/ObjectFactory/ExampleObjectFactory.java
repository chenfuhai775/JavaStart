package com.example.demo.ObjectFactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class ExampleObjectFactory extends DefaultObjectFactory {

    private static final long serialVersionUID = -8855120656740914948L;

    @Override
    public Object create(Class type) {
        return super.create(type);
    }

    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T ret = super.create(type, constructorArgTypes, constructorArgs);
        if(ShoppingCart.class.isAssignableFrom(type)){
            ShoppingCart entity = (ShoppingCart)ret;
            entity.init();
        }
        return ret;
    }

    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }
}
