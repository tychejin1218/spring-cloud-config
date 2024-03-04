package com.example.springcloudconfigclient.controller;

import com.example.springcloudconfigclient.service.ConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

  private final ConfigService configService;

  public ConfigController(ConfigService configService) {
    this.configService = configService;
  }

  @GetMapping("/config")
  public ResponseEntity<?> getConfig() {
    return ResponseEntity.ok(configService.getConfig());
  }
}
