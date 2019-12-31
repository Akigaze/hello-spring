package demo.qf.spring.autowire;

public class House {
  private Integer number;
  private Person host;

  public House(Integer number, Person host) {
    this.number = number;
    this.host = host;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Person getHost() {
    return host;
  }

  @Override
  public String toString() {
    return "House{" +
      "number=" + number +
      ", host=" + host +
      '}';
  }
}
