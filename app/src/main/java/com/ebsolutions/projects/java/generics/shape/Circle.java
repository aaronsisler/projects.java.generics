package com.ebsolutions.projects.java.generics.shape;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Circle extends Shape {
  protected final Integer area;
}

