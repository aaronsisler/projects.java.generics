package com.ebsolutions.projects.java.generics.account;

import org.springframework.stereotype.Component;

@Component
public class AccountFileReaderFactory {

  public AccountFileReaderService<?> getAccountFileReaderService(CardType cardType) {
    if (cardType == null || cardType.getDtoClass() == null) {
      throw new IllegalArgumentException("Invalid or unsupported card type: " + cardType);
    }

    return new AccountFileReaderService<>(cardType.getDtoClass());
  }
}
