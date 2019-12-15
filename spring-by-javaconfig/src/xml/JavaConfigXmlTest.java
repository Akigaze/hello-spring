package xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigXmlTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigXmlConfig.class);

    CDPlayer cdPlayer = (CDPlayer) context.getBean("cdPlayer");
    CDPlayer player = (CDPlayer) context.getBean("player");
    Musician musician = (Musician) context.getBean("musician");
    Musician mozart = (Musician) context.getBean("mozart");

    cdPlayer.play();
    musician.listenMusic();
    mozart.listenMusic();

    System.out.println(cdPlayer == musician.getCdPlayer());
    System.out.println(player == musician.getCdPlayer());
    System.out.println(player == mozart.getCdPlayer());
  }
}
