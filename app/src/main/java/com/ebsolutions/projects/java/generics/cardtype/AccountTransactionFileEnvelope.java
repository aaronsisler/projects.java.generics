package com.ebsolutions.projects.java.generics.cardtype;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class AccountTransactionFileEnvelope {
  private MultipartFile file;
  private CardType cardType;
}
