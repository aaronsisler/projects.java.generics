package com.ebsolutions.projects.java.generics.shape;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Shape {
  private final Integer value = 0;

  public static Shape create(AllowedShapes allowedShapes) {
    return switch (allowedShapes) {
      case AllowedShapes.CIRCLE -> Circle.builder().build();
      case AllowedShapes.SQUARE -> Square.builder().build();
    };
  }
}
