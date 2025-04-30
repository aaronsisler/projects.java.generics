package com.ebsolutions.projects.java.generics.interfaces;

public class Jet implements FlightEnabled {
  @Override
  public void takeOff() {
    System.out.println(getClass().getSimpleName() + " is taking off!");
  }

  @Override
  public void land() {
    System.out.println(getClass().getSimpleName() + " is landing.");

  }

  @Override
  public void fly() {
    System.out.println(getClass().getSimpleName() + " is flying!");

  }
}
