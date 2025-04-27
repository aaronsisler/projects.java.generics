package com.ebsolutions.projects.java.generics.shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Box<T> {
  private T content;
}
