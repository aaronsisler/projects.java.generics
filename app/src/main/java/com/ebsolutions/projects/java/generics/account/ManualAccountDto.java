package com.ebsolutions.projects.java.generics.account;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManualAccountDto {
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
