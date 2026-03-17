package com.muvi.api.utils;

import com.muvi.api.pojo.Product;

public class PayLoadBuilder {
    public static Product createEmployee(String title, int price) {
    	Product product=new Product();
    	product.setPrice(price);
    	product.setTitle(title);
       
        return product;
    }
    
    
}