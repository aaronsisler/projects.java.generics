package com.ebsolutions.projects.java.generics.account.dto;

public abstract class AccountDto {
  abstract Integer getRowId();

  abstract String getAmount();

  abstract String getDescription();

  abstract String getTransactionDate();
}
