package com.ebsolutions.projects.java.generics.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CardType {
  AMEX(AmexAccountDto.class),
  MANUAL(ManualAccountDto.class),
  // Add more card types and DTOs here
  ;

  private final Class<?> dtoClass;
}
