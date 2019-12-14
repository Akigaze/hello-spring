package com.aop.aspectj;

import com.aop.universal.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StringCalculator implements Calculator<String> {
  @Override
  public String add(String augend, String addend) {
    return augend + addend;
  }

  @Override
  public String subtract(String minuend, String subtrahend) {
    return String.join("", minuend.split(subtrahend));
  }

  @Override
  public String multiply(String multiplicand, String multiplier) {
    boolean moreChar = true;
    int i = 0;
    StringBuilder builder = new StringBuilder();
    while (moreChar) {
      moreChar = false;
      if (multiplicand.length() > i) {
        moreChar = true;
        builder.append(multiplicand.charAt(i));
      }
      if (multiplier.length() > i) {
        moreChar = true;
        builder.append(multiplier.charAt(i));
      }
      i++;
    }
    return builder.toString();
  }

  @Override
  public String divide(String dividend, String divisor) {
    int i = 0;
    StringBuilder builder = new StringBuilder(dividend);
    while (true) {
      if (divisor.length() > i) {
        char remover = divisor.charAt(i);
        int index = builder.indexOf(String.valueOf(remover));
        if (index > -1) {
          builder.deleteCharAt(index);
        }
      }
      if (divisor.length() <= i || builder.length() == 0) {
        break;
      }
      i++;
    }
    return builder.toString();
  }

  @Override
  public void square(String cardinality) {
    throw new RuntimeException("...");
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("com/aop/aspectj/aspectjApplicationContext.xml");
    Calculator calculator1 = (Calculator) context.getBean("stringCalculator");
    System.out.println("------ add ------");
    calculator1.add("hello", "world");
    System.out.println("\n------ subtract ------\n");
    calculator1.subtract("good morning", "morn");
    System.out.println("\n------ multiply ------\n");
    calculator1.multiply("good job", "nice boy");
    System.out.println("\n------ divide ------\n");
    calculator1.divide("everything", "election");
    System.out.println("\n------ square ------\n");
    calculator1.square("exception");
  }

}
