package com.ebsolutions.projects.java.generics.account.factory;

import com.ebsolutions.projects.java.generics.account.SupportedInstitution;
import com.ebsolutions.projects.java.generics.account.dto.ManualAccountDto;
import org.springframework.stereotype.Component;

@Component
public class ManualAccountFileReaderFactory extends AccountFileReaderFactory<ManualAccountDto> {

  @Override
  protected Class<ManualAccountDto> getDtoClass(SupportedInstitution supportedInstitution) {
    if (supportedInstitution != SupportedInstitution.MANUAL) {
      throw new IllegalArgumentException("This factory only supports MANUAL");
    }
    return ManualAccountDto.class;
  }
}
