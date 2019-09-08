package com.example.demo;

import java.io.Serializable;

public class PrintTest implements Cloneable, Serializable {

    public static final long serivalVersion = 1L;

    private String name;

    public PrintTest() {
        System.out.println("this is Constructor");
    }

    public void hello() {
        System.out.println("hello ");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrintTest other = (PrintTest) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PrintTest [name=" + name + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
