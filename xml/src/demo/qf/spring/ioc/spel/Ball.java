package demo.qf.spring.ioc.spel;

public class Ball {
  private Circle circle;
  private String type;
  private double volume;

  public Ball() {
    System.out.println("use Ball no args constructor");
  }

  public void setCircle(Circle circle) {
    System.out.println("set Ball circle: " + circle);
    this.circle = circle;
  }

  public void setType(String type) {
    System.out.println("set Ball type: " + type);
    this.type = type;
  }

  public void setVolume(double volume) {
    System.out.println("set Ball volume: " + volume);
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "Ball{" +
      "circle=" + circle +
      ", type=" + type +
      ", volume=" + volume + "立方米" +
      '}';
  }

}

