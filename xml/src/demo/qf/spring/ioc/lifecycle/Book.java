package demo.qf.spring.ioc.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Book {
  private String name;
  private String author;
  private int pageSize;
  private String status;

  public Book() {
    System.out.println("Book: no argument constructor");
  }

  public Book(String name, String author, int pageSize, String status) {
    System.out.println("Book: all arguments constructor");
    this.name = name;
    this.author = author;
    this.pageSize = pageSize;
    this.status = status;
  }

  public void setName(String name) {
    System.out.println("set book name: " + name);
    this.name = name;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void onSale() {
    System.out.println("init-method: " + this.name + " is " + this.status + " and will become selling");
    this.status = "selling";
  }

  public void recycle() {
    System.out.println("destroy-method: " + this.name + " is " + this.status + " and will become recycled");
    this.status = "recycled";
  }

  @Override
  public String toString() {
    return "Book{" +
      "name='" + name + '\'' +
      ", author='" + author + '\'' +
      ", pageSize=" + pageSize +
      ", status='" + status + '\'' +
      '}';
  }

  public static void main(String[] args) {
    String configLocation = "demo/qf/spring/ioc/lifecycle/lifecycleApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

    Book byaKuYaKo = (Book) context.getBean("byaKuYaKo");
    System.out.println(byaKuYaKo);
    System.out.println("\n-------------------\n");

    Book houGaGou1 = (Book) context.getBean("houGaGou");
    System.out.println(houGaGou1);
    Book houGaGou2 = (Book) context.getBean("houGaGou");

    System.out.println("\n--------- close context ----------\n");

    ((ClassPathXmlApplicationContext) context).close();
    System.out.println(byaKuYaKo);
    System.out.println(houGaGou1);
    System.out.println(houGaGou2);

  }
}
