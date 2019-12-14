package com.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
    private String brand;
    private int price;
    private double size;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("factory-bean.xml");
        Mobile huawei = (Mobile) context.getBean("huawei");
        System.out.println(huawei);

        Mobile vivo = (Mobile) context.getBean("vivo");
        System.out.println(vivo);

        Mobile mi = (Mobile) context.getBean("mi");
        System.out.println(mi);
    }
}
