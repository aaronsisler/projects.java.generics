package com.ebsolutions.projects.java.generics.account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AccountDto {
  protected Integer rowId;
  protected String amount;
  protected String description;
  protected String transactionDate;
}
