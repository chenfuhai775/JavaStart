package com.example.demo.framework;

public class URL {
    private String hosetname;

    public void setHosetname(String hosetname) {
        this.hosetname = hosetname;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHosetname() {
        return hosetname;
    }

    public Integer getPort() {
        return port;
    }

    private Integer port;

    public URL(String hosetname,Integer port){
        this.hosetname = hosetname;
        this.port = port;
    }
}
