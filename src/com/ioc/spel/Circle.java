package com.ioc.spel;

public class Circle {
  private int radius;
  private double perimeter;
  private double area;
  private double density;

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public void setPerimeter(double perimeter) {
    this.perimeter = perimeter;
  }

  public void setArea(double area) {
    this.area = area;
  }

  public void setDensity(double density) {
    this.density = density;
  }

  public int getRadius() {
    return radius;
  }

  public double calBallVolume() {
    return Math.PI * Math.pow(this.radius, 2) * 3 / 4;
  }

  @Override
  public String toString() {
    return "Circle{" +
      "radius=" + radius +
      ", perimeter=" + perimeter +
      ", area=" + area +
      ", density=" + density +
      '}';
  }

}
