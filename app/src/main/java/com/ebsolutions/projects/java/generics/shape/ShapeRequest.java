package com.ebsolutions.projects.java.generics.shape;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShapeRequest {
  private AllowedShapes shape;
}
