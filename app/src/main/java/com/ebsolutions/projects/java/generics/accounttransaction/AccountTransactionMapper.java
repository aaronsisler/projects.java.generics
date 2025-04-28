package com.ebsolutions.projects.java.generics.accounttransaction;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.util.List;

public class AccountTransactionMapper<T> {
  public List<T> processFile(Reader reader, Class<T> clazz) {
    CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
        .withType(clazz)
        .build();

    return cb.parse();
  }
}
