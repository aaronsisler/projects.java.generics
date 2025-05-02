package com.ebsolutions.projects.java.generics.account;

import com.ebsolutions.projects.java.generics.account.dto.AccountDto;

public abstract class AccountFileReaderFactory<T extends AccountDto> {

  public AccountFileReaderService<T> create(SupportedInstitution supportedInstitution) {
    if (supportedInstitution == null || supportedInstitution.getDtoClass() == null) {
      throw new IllegalArgumentException(
          "Invalid or unsupported card type: " + supportedInstitution);
    }
    return new AccountFileReaderService<>(getDtoClass(supportedInstitution));
  }

  protected abstract Class<T> getDtoClass(SupportedInstitution supportedInstitution);
}
