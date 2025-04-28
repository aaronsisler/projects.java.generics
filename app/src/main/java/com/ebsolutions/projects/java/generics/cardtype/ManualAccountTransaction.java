package com.ebsolutions.projects.java.generics.cardtype;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.validation.constraints.NotBlank;
import lombok.ToString;

@ToString
public class ManualAccountTransaction {
  private Integer rowId;
  @NotBlank(message = "Amount cannot be blank")
  @CsvBindByPosition(position = 0)
  private String amount;
  @NotBlank(message = "Description cannot be blank")
  @CsvBindByPosition(position = 1)
  private String description;
  @NotBlank(message = "Transaction date cannot be blank")
  @CsvBindByPosition(position = 2)
  private String transactionDate;
}
