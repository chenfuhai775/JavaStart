package com.example.demo.socket;

public class ServerApplication {
    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        socketServer.start();
    }
}
