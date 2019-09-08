package com.example.demo.provider;

import com.example.demo.framework.URL;
import com.example.demo.protocol.http.HttpServer;
import com.example.demo.provider.api.HelloService;
import com.example.demo.provider.impl.HelloServiceImpl;
import com.example.demo.register.RemoteMapRegister;

public class Provider {
    public static void main(String[] args) {
        //1.本地注册
        //{服务名：实现类}
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);
        //2.远程注册
        // {服务名：List<URI>}
        URL url = new URL("127.0.0.1", 9090);
        RemoteMapRegister.register(HelloService.class.getName(), url);
        //3.暴露服务(启动tomcat)
        HttpServer httpServer = new HttpServer();
        httpServer.start("127.0.0.1", 9090);

    }
}
