package com.beans.autowire;

public class Entrepreneur {
    private String name;
    private int age;
    private long asset;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getAsset() {
        return asset;
    }

    public void setAsset(long asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "Entrepreneur{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", asset=" + asset +
                '}';
    }
}
