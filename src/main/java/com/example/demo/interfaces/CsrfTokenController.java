package com.example.demo.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.web.csrf.CsrfToken;

@Slf4j
@RestController
public class CsrfTokenController extends AbstractController {

  @GetMapping(value = "/cms/csrf-token", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<String> csrf(CsrfToken token) {
    String json = null;
    HttpStatus status = HttpStatus.OK;

    try {
      json = mapper.writeValueAsString(token);

    } catch (JsonProcessingException e) {
      log.error("error occurs: ", e);
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }


    return new ResponseEntity<>(json, status);
  }
}
