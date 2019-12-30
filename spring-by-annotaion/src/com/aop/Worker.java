package com.aop;

public class Worker {
  private String name;
  private boolean ill = false;

  Worker(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  void setIll(boolean ill) {
    this.ill = ill;
  }

  @Loggable(desc = "good good work")
  Object work() throws Exception {
    if (this.ill) {
      throw new Exception("I am ill, couldn't work");
    }
    int product = (int) (Math.random() * 10);
    return this.name + " - " + product;
  }

  void goHome() {
    System.out.println(this.name + " goes home");
  }
}
