package demo.qf.spring.ioc.injection;

public class Car {
  private String brand;
  private double price;
  private int maxSpeed;

  public Car(String brand) {
    System.out.println("use Car band arg constructor: " + brand);
    this.brand = brand;
  }

  public Car(String brand, double price) {
    System.out.println("use Car band, price arg constructor");
    this.brand = brand;
    this.price = price;
  }

  public Car(String brand, int maxSpeed) {
    System.out.println("use Car band, maxSpeed arg constructor");
    this.brand = brand;
    this.maxSpeed = maxSpeed;
  }

  public void setPrice(double price) {
    System.out.println("set Car price: " + price);
    this.price = price;
  }

  public void setMaxSpeed(int maxSpeed) {
    System.out.println("set Car maxSpeed: " + maxSpeed);
    this.maxSpeed = maxSpeed;
  }

  @Override
  public String toString() {
    return "Car{" +
      "brand='" + brand + '\'' +
      ", price=" + price +
      ", maxSpeed=" + maxSpeed +
      '}';
  }

}
