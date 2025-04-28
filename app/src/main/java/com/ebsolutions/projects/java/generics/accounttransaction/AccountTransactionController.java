package com.ebsolutions.projects.java.generics.accounttransaction;

import jakarta.validation.Valid;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("account-transactions")
public class AccountTransactionController {
  private final AccountTransactionService accountTransactionService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> post(
      @Valid @ModelAttribute AccountTransactionFileEnvelope accountTransactionFileEnvelope)
      throws IOException {

    accountTransactionService.process(accountTransactionFileEnvelope);

    return ResponseEntity.ok().build();
  }
}
