package com.ebsolutions.projects.java.generics.account.factory;

import com.ebsolutions.projects.java.generics.account.AccountFileReaderFactory;
import com.ebsolutions.projects.java.generics.account.SupportedInstitution;
import com.ebsolutions.projects.java.generics.account.dto.AmexAccountDto;

public class AmexAccountFileReaderFactory extends AccountFileReaderFactory<AmexAccountDto> {

  @Override
  protected Class<AmexAccountDto> getDtoClass(SupportedInstitution supportedInstitution) {
    if (supportedInstitution != SupportedInstitution.AMEX) {
      throw new IllegalArgumentException("This factory only supports AMEX");
    }
    return AmexAccountDto.class;
  }
}
