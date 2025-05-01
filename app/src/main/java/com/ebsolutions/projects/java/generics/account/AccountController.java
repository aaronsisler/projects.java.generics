package com.ebsolutions.projects.java.generics.account;

import jakarta.validation.Valid;
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
@RequestMapping("accounts")
public class AccountController {

  private final AccountFileReaderFactory accountFileReaderFactory;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> post(@Valid @ModelAttribute AccountRequest accountRequest) {

    try {
      AccountFileReaderService<?> readerService =
          accountFileReaderFactory.getAccountFileReaderService(accountRequest.getCardType());

      List<?> result = readerService.process(accountRequest);
      return ResponseEntity.ok(result);

    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }
}