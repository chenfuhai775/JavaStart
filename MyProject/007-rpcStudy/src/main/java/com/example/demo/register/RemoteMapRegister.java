package com.example.demo.register;

import com.example.demo.framework.URL;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteMapRegister {
    private static Map<String, List<URL>> register = new HashMap<String, List<URL>>();

    public static void register(String interfaceName, URL url) {
        List<URL> list = Collections.singletonList(url);
        register.put(interfaceName,list);
    }
}
