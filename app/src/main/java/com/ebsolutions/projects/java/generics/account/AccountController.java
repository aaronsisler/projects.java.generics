package com.ebsolutions.projects.java.generics.account;

import com.ebsolutions.projects.java.generics.account.dto.AccountDto;
import com.ebsolutions.projects.java.generics.account.factory.AccountFileReaderFactory;
import com.ebsolutions.projects.java.generics.account.factory.AccountFileReaderFactoryRegistry;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("accounts")
public class AccountController {

  private final AccountFileReaderFactoryRegistry factoryRegistry;


  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> post(@Valid @ModelAttribute AccountRequest accountRequest) {

    try {
      AccountFileReaderFactory<? extends AccountDto> factory =
          factoryRegistry.getFactory(accountRequest.getSupportedInstitution());

      AccountFileReaderService<? extends AccountDto> readerService =
          factory.create(accountRequest.getSupportedInstitution());
      List<? extends AccountDto> result = readerService.process(accountRequest);

      return ResponseEntity.ok(result);

    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  public ResponseEntity<List<? extends AccountDto>> processFile(
      @RequestParam("institution") SupportedInstitution institution,
      @ModelAttribute AccountRequest accountRequest
  ) throws Exception {

    AccountFileReaderFactory<? extends AccountDto> factory =
        factoryRegistry.getFactory(institution);
    AccountFileReaderService<? extends AccountDto> readerService = factory.create(institution);
    List<? extends AccountDto> result = readerService.process(accountRequest);

    return ResponseEntity.ok(result);
  }
}