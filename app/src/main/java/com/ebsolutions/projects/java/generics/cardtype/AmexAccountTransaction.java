package com.ebsolutions.projects.java.generics.cardtype;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.validation.constraints.NotBlank;
import lombok.ToString;

@ToString
public class AmexAccountTransaction {
  protected Integer rowId;
  @NotBlank(message = "Amount cannot be blank")
  @CsvBindByPosition(position = 4)
  protected String amount;
  @NotBlank(message = "Description cannot be blank")
  @CsvBindByPosition(position = 1)
  protected String description;
  @NotBlank(message = "Transaction date cannot be blank")
  @CsvBindByPosition(position = 0)
  protected String transactionDate;
}
