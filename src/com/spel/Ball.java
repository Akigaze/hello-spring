package com.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ball {
    private Circle circle;
    private String type;
    private double volume;

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "circle=" + circle +
                ", type=" + type +
                ", volume=" + volume + "立方米" +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spel.xml");
        Ball ball1 = (Ball) context.getBean("ball1");
        System.out.println(ball1);
    }
}
