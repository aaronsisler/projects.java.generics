package com.ebsolutions.projects.java.generics.account;

import lombok.Getter;

@Getter
public enum CardType {
  AMEX(AmexAccountDto.class),
  MANUAL(ManualAccountDto.class),
  // Add more card types and DTOs here
  ;

  private final Class<?> dtoClass;

  CardType(Class<?> dtoClass) {
    this.dtoClass = dtoClass;
  }
}
