package com.ebsolutions.projects.java.generics.account;

import com.ebsolutions.projects.java.generics.account.dto.AmexAccountDto;
import com.ebsolutions.projects.java.generics.account.dto.ManualAccountDto;
import lombok.Getter;

@Getter
public enum SupportedInstitution {
  AMEX(AmexAccountDto.class),
  MANUAL(ManualAccountDto.class),
  // Add more card types and DTOs here
  ;

  private final Class<?> dtoClass;

  SupportedInstitution(Class<?> dtoClass) {
    this.dtoClass = dtoClass;
  }
}
