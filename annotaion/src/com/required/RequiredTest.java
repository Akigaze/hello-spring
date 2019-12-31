package com.required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RequiredTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(RequiredConfig.class);
    Paper paper = (Paper) context.getBean("paper");
    Book book = (Book) context.getBean("book");
    Book bookNotRequirePaper = (Book) context.getBean("bookNotRequirePaper");

    System.out.println(book.getPaper());
    System.out.println(book.getPaper() == paper);
    System.out.println(bookNotRequirePaper.getPaper());
  }
}
