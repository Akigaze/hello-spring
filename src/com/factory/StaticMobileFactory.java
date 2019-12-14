package com.factory;

public class StaticMobileFactory {

    public static Mobile productMobile(String brand){
        Mobile mobile = new Mobile();
        mobile.setBrand(brand);
        return mobile;
    }
}
