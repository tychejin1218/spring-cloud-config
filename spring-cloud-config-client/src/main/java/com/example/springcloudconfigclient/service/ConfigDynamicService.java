package com.example.springcloudconfigclient.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class ConfigDynamicService {

  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;

  public Map<String, String> getConfig() {
    Map<String, String> map = new HashMap<>();
    map.put("driverClassName", driverClassName);
    map.put("url", url);
    map.put("username", username);
    map.put("password", password);
    return map;
  }
}
