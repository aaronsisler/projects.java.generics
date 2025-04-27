package com.ebsolutions.projects.java.generics.shape;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Square extends Shape {
  private final Integer value = 2;
}
