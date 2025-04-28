package com.ebsolutions.projects.java.generics.accounttransaction;

import com.ebsolutions.projects.java.generics.accounttransaction.model.AmexAccountTransaction;
import com.ebsolutions.projects.java.generics.accounttransaction.model.ManualAccountTransaction;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionService {
  public void process(AccountTransactionFileEnvelope accountTransactionFileEnvelope)
      throws IOException {
    try (Reader reader = new InputStreamReader(
        accountTransactionFileEnvelope.getFile().getInputStream())) {
      switch (accountTransactionFileEnvelope.getCardType()) {
        case CardType.AMEX -> {
          AccountTransactionMapper<AmexAccountTransaction> accountTransactionMapper =
              new AccountTransactionMapper<>();
          List<AmexAccountTransaction> amexAccountTransactions =
              accountTransactionMapper.processFile(reader, AmexAccountTransaction.class);

          amexAccountTransactions.forEach(System.out::println);
        }
        case CardType.MANUAL -> {
          AccountTransactionMapper<ManualAccountTransaction> accountTransactionMapper =
              new AccountTransactionMapper<>();
          List<ManualAccountTransaction> manualAccountTransactions =
              accountTransactionMapper.processFile(reader, ManualAccountTransaction.class);

          manualAccountTransactions.forEach(System.out::println);
        }
      }
    }
  }
}
