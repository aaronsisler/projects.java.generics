package com.ebsolutions.projects.java.generics.account;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountFileReaderService {
  public void process(AccountRequest accountRequest) throws Exception {
    if (accountRequest.getFile() == null) {
      throw new Exception("File cannot be null");
    }

    if (accountRequest.getFile().isEmpty()) {
      throw new Exception("File cannot be empty");
    }

    // Parse the CSV and create a DTO for each row
    try (Reader reader = new InputStreamReader(accountRequest.getFile().getInputStream())) {

      if (CardType.AMEX.equals(accountRequest.getCardType())) {
        AccountCsvService<AmexAccountDto> accountCsvService = new AccountCsvService<>();
        List<AmexAccountDto> amexAccountDtos =
            accountCsvService.processFile(reader, AmexAccountDto.class);

        amexAccountDtos.forEach(System.out::println);
      }
    } catch (IOException e) {
      throw new Exception("File was not able to be parsed");
    }
  }
}
