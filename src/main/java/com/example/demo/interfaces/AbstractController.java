package com.example.demo.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public abstract class AbstractController {
  protected ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(
    PropertyNamingStrategy.SNAKE_CASE);
}
