package com.ebsolutions.projects.java.generics.account;

import jakarta.validation.Valid;
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
  private final AccountFileReaderService accountFileReaderService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> post(@Valid @ModelAttribute AccountRequest accountRequest) {

    try {

      accountFileReaderService.process(accountRequest);
      return ResponseEntity.ok().build();

    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e);
    }
  }
}
