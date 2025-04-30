package com.ebsolutions.projects.java.generics.animals;

import lombok.ToString;

@ToString
public class Dog extends Mammal {
  public Dog(String type, String size, int weight) {
    super(type, size, weight);
  }

  @Override
  public void makeNoise() {
    if (type.equals("Wolf")) {
      System.out.println("Howl!!!!!!");
    } else {
      System.out.println("Woof woof!");
    }
  }

  @Override
  public void move(String speed) {
    if (speed.equals("slow")) {
      System.out.println(getExplicitType() + " walking.");
    } else {
      System.out.println(getExplicitType() + " running!");
    }
  }

  @Override
  public void shedHair() {
    System.out.println(getExplicitType() + " sheds all the time!");

  }
}
