package com.antowire;


public class Engine {
  private String band;

  public Engine(String band) {
    this.band = band;
  }

  @Override
  public String toString() {
    return "Engine{" +
      "band='" + band + '\'' +
      '}';
  }
}
