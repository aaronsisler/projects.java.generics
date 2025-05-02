package com.ebsolutions.projects.java.generics.account;

import com.ebsolutions.projects.java.generics.account.dto.AccountDto;
import com.ebsolutions.projects.java.generics.account.factory.AmexAccountFileReaderFactory;
import com.ebsolutions.projects.java.generics.account.factory.ManualAccountFileReaderFactory;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountFileReaderFactoryRegistry {

  private final Map<SupportedInstitution, AccountFileReaderFactory<? extends AccountDto>>
      factories = new HashMap<>();

  @Autowired
  public AccountFileReaderFactoryRegistry(
      AmexAccountFileReaderFactory amexFactory,
      ManualAccountFileReaderFactory manualFactory
  ) {
    factories.put(SupportedInstitution.AMEX, amexFactory);
    factories.put(SupportedInstitution.MANUAL, manualFactory);
  }

  public AccountFileReaderFactory<? extends AccountDto> getFactory(
      SupportedInstitution institution) {
    AccountFileReaderFactory<? extends AccountDto> factory = factories.get(institution);
    if (factory == null) {
      throw new IllegalArgumentException("Unsupported institution: " + institution);
    }
    return factory;
  }
}
