package com.ebsolutions.projects.java.generics.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class AccountRequest {
  private SupportedInstitution supportedInstitution;
  private MultipartFile file;
}
