package com.ebsolutions.projects.java.generics.animals;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public abstract class Animal {
  protected String type;
  protected String size;
  protected int weight;

  public abstract void makeNoise();

  public abstract void move(String speed);

  public String getExplicitType() {
    return getClass().getSimpleName() + " (" + type + ")";
  }
}
