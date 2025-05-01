package com.ebsolutions.projects.java.generics.account;

public abstract class AccountDto {
  abstract Integer getRowId();

  abstract String getAmount();

  abstract String getDescription();

  abstract String getTransactionDate();
}
