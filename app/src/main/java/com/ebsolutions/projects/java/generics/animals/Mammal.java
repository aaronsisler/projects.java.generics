package com.ebsolutions.projects.java.generics.animals;

public abstract class Mammal extends Animal {

  public Mammal(String type, String size, int weight) {
    super(type, size, weight);
  }

  @Override
  public void move(String speed) {
    System.out.println(getExplicitType() + (speed.equals("slow") ? " walks." : " runs!"));
  }

  public abstract void shedHair();
}
