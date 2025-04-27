package com.ebsolutions.projects.java.generics.shape;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public abstract class Shape {
  protected Integer area = 0;
  protected AllowedShapes shape;

  public static Shape create(AllowedShapes allowedShapes, Integer area) {
    return switch (allowedShapes) {
      case AllowedShapes.CIRCLE -> Circle.builder()
          .area(area)
          .shape(allowedShapes)
          .build();
      case AllowedShapes.SQUARE -> Square.builder()
          .area(area)
          .shape(allowedShapes)
          .build();
    };
  }
}
