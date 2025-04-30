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

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> post(@Valid @ModelAttribute AccountRequest accountRequest) {

    try {

      if (CardType.AMEX.equals(accountRequest.getCardType())) {
        AccountFileReaderService<AmexAccountDto> accountFileReaderService =
            new AccountFileReaderService<>(
                AmexAccountDto.class);
        List<AmexAccountDto> amexAccountDtos = accountFileReaderService.process(accountRequest);
        return ResponseEntity.ok(amexAccountDtos);
      }

      return ResponseEntity.ok().build();

    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e);
    }
  }
}
