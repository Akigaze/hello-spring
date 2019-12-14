package com.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class City {
    private String name;
    private String alias;
    private int population;
    private double area;
    private long gdp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public long getGdp() {
        return gdp;
    }

    public void setGdp(long gdp) {
        this.gdp = gdp;
    }

    @Override
    public String toString() {
        return "City{" +
                "name=" + name +
                "，alias=" + alias +
                ", population=" + population/10000 + "万" +
                ", area=" + area + "平方公里" +
                ", gdp=" + gdp/100000000 + "亿" +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spel.xml");
        City guangZhou = (City) context.getBean("guang-zhou");
        System.out.println(guangZhou);
    }
}
