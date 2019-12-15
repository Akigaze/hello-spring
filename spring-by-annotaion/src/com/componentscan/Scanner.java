package com.componentscan;

import org.springframework.stereotype.Component;

@Component
public class Scanner {
  private String band;

  public void setBand(String band) {
    this.band = band;
  }

  public void scan() {
    System.out.println(this.band + "is scanning");
  }
}
