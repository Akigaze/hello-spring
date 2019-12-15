package com.xml;

public class Musician {
  private String name;
  private CDPlayer cdPlayer;

  public CDPlayer getCdPlayer() {
    return cdPlayer;
  }

  public Musician(String name, CDPlayer cdPlayer) {
    this.name = name;
    this.cdPlayer = cdPlayer;
  }

  public void listenMusic() {
    System.out.print(this.name + "is listening music. ");
    cdPlayer.play();
  }
}
