package com.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class PropertyValueTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ValueConfig.class);

    System.out.println("-------- IOC container ready --------");

    String myName = (String) context.getBean("myName");
    int myAge = (int) context.getBean("myAge");
    boolean isBoy = (boolean) context.getBean("isBoy");
    List<String> myParents = (List<String>) context.getBean("myParents");
    List<String> myEyes = (List<String>) context.getBean("myEyes");

    System.out.println("My name is " + myName);
    System.out.println("I am " + myAge + " years ago");
    System.out.println("I am a " + (isBoy ? "boy" : "girl"));
    System.out.println("There are my parents " + myParents);
    System.out.println("There are my eyes " + myEyes);

    System.out.println("-------------------------");

    Clazz clazz = (Clazz) context.getBean("clazz");

    System.out.println(clazz);

    System.out.println("-------------------------");

    List<Integer> grades = (List<Integer>) context.getBean("grades");
    List<String> teachers = (List<String>) context.getBean("teachers");
    boolean isNational = (boolean) context.getBean("isNational");
    Map<String, Integer> duty = (Map<String, Integer>) context.getBean("duty");
    int studentTotal = (int) context.getBean("studentTotal");

    System.out.println(grades);
    System.out.println(teachers);
    System.out.println(duty);
    System.out.println("is this a national school: " + isNational);
    System.out.println("Total student number: " + studentTotal);

    System.out.println("*********************");

    String unknownValue = (String) context.getBean("unknownValue");
    String defaultValue = (String) context.getBean("valueWithDefault");

    System.out.println(unknownValue);
    System.out.println(defaultValue);

    System.out.println("*********************");

    String spelWithDefault = (String) context.getBean("spelWithDefault");
    List<String> teacherList = (List<String>) context.getBean("teacherList");

    System.out.println(spelWithDefault);
    System.out.println(teacherList);
  }
}
