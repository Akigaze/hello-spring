package hellojavaconfig;

public class HelloBean {
  private String text;

  HelloBean() {
    System.out.println("HelloBean: non arguments constructor");
  }

  void setText(String text) {
    this.text = text;
  }

  void greet() {
    System.out.println("Hello, " + this.text);
  }

}
