package com.componentscan;

import org.springframework.stereotype.Component;

@Component
public class Scanner {
  private String band;

  void setBand(String band) {
    this.band = band;
  }

  void scan() {
    System.out.println(this.band + "is scanning");
  }
}
