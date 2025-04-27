package com.ebsolutions.projects.java.generics.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

public class MapperConfig {
  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper().findAndRegisterModules();
  }
}
