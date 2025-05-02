package com.ebsolutions.projects.java.generics.account;

import com.ebsolutions.projects.java.generics.account.dto.AccountDto;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class AccountFileReaderService<T extends AccountDto> {

  private final Class<T> clazz;

  public AccountFileReaderService(Class<T> clazz) {
    this.clazz = clazz;
  }

  public List<T> process(AccountRequest accountRequest) throws Exception {
    if (accountRequest.getFile() == null) {
      throw new Exception("File cannot be null");
    }

    if (accountRequest.getFile().isEmpty()) {
      throw new Exception("File cannot be empty");
    }

    try (Reader reader = new InputStreamReader(accountRequest.getFile().getInputStream())) {
      AccountCsvService<T> accountCsvService = new AccountCsvService<>();
      return accountCsvService.processFile(reader, clazz);
    } catch (IOException e) {
      throw new Exception("File was not able to be parsed", e);
    }
  }
}
