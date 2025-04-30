package com.ebsolutions.projects.java.generics.animals;

public class Horse extends Mammal {
  public Horse(String type, String size, int weight) {
    super(type, size, weight);
  }

  @Override
  public void shedHair() {
    System.out.println(getExplicitType() + " sheds in the Spring.");
  }

  @Override
  public void makeNoise() {
    System.out.println(getExplicitType() + " neighs!");
  }
}
