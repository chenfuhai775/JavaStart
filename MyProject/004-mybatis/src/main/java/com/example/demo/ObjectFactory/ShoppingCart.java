package com.example.demo.ObjectFactory;

import lombok.Data;

@Data
public class ShoppingCart {
    private int productId;
    private String productName;
    private int number;
    private double price;
    private double totalAmount;

    public ShoppingCart(){}

    public ShoppingCart(int productId,String productName,int number,double price,double totalAmount){
        super();
        this.productId = productId;
        this.productName = productName;
        this.number = number;
        this.price = price;
        this.totalAmount = totalAmount;
    }

    public void init(){
        this.totalAmount = this.number * this.price;
    }
}
