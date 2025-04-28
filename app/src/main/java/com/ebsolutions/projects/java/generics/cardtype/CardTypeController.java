package com.ebsolutions.projects.java.generics.cardtype;

import jakarta.validation.Valid;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("card-types")
public class CardTypeController {

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> post(
      @Valid @ModelAttribute AccountTransactionFileEnvelope accountTransactionFileEnvelope)
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

      return ResponseEntity.ok().build();
    }

  }
}
