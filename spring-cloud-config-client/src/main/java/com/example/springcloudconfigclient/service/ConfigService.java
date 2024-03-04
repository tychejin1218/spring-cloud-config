package com.example.springcloudconfigclient.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;

  public Map<String, String> getConfig() {
    return Map.of(
        "url", url,
        "driverClassName", driverClassName,
        "username", username,
        "password", password
    );
  }
}
