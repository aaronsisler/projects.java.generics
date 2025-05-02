package com.ebsolutions.projects.java.generics.account.factory;

import com.ebsolutions.projects.java.generics.account.AccountFileReaderFactory;
import com.ebsolutions.projects.java.generics.account.SupportedInstitution;
import com.ebsolutions.projects.java.generics.account.dto.ManualAccountDto;

public class ManualAccountFileReaderFactory extends AccountFileReaderFactory<ManualAccountDto> {

  @Override
  protected Class<ManualAccountDto> getDtoClass(SupportedInstitution supportedInstitution) {
    if (supportedInstitution != SupportedInstitution.MANUAL) {
      throw new IllegalArgumentException("This factory only supports MANUAL");
    }
    return ManualAccountDto.class;
  }
}
