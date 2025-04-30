package com.ebsolutions.projects.java.generics.account;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.util.List;

public class AccountCsvService<T> {

  public List<T> processFile(Reader reader, Class<T> clazz) {
    CsvToBean<T> cb;
    cb = new CsvToBeanBuilder<T>(reader)
        .withType(clazz)
        .build();

    List<T> accountTransactionDtos = cb.parse();

    System.out.println(accountTransactionDtos);

    return accountTransactionDtos;
  }
}
