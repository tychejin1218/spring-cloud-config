package com.example.springcloudconfigclient.controller;

import com.example.springcloudconfigclient.service.ConfigDynamicService;
import com.example.springcloudconfigclient.service.ConfigStaticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ConfigController {

  private final ConfigStaticService configStaticService;
  private final ConfigDynamicService configDynamicService;

  @GetMapping("/static/config")
  public ResponseEntity<?> getStaticConfig() {
    return ResponseEntity.ok(configStaticService.getConfig());
  }

  @GetMapping("/dynamic/config")
  public ResponseEntity<?> getDynamicConfig() {
    return ResponseEntity.ok(configDynamicService.getConfig());
  }
}
