package com.ebsolutions.projects.java.generics.shape;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Circle extends Shape {
  private final Integer value = 1;
}

