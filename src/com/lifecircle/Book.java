package com.lifecircle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Book {
  private String name;
  private String author;
  private int pageSize;

  public Book() {
    System.out.println("create bean by no argument constructor");
  }

  public Book(String name, String author, int pageSize) {
    this.name = name;
    this.author = author;
    this.pageSize = pageSize;
    System.out.println("create bean by all argument constructor");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    System.out.println("set book name:" + name);
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public void onSale() {
    System.out.println(this.name + " is on sale and wait to be buy");
  }

  public void recycle() {
    System.out.println(this.name + " is recycled");
  }

  @Override
  public String toString() {
    return this.name + "被使用.";
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("bean-life-circle.xml");

    Book baiyexing = (Book) context.getBean("baiyexing");
    System.out.println(baiyexing);
    System.out.println("--------- 华丽分割线 -----------");

    Book fangxuehou = (Book) context.getBean("fangxuehou");
    System.out.println(fangxuehou);

    ((ClassPathXmlApplicationContext) context).close();
  }
}
