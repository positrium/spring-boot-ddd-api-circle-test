package com.example.demo.domain.model.note;


import groovy.util.logging.Slf4j;
import lombok.Value;

import java.util.regex.Pattern;

@Slf4j
@Value
public class NoteId {
  String value;

  public NoteId(String value) {
    validateUUID(value);

    this.value = value;
  }

  private void validateUUID(String value) {
    String inputPattern = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";

    if (!Pattern.matches(inputPattern, value)) {
      throw new RuntimeException("入力文字種が正しくありません。期待値[" + inputPattern + "] [value=" + value + "]");
    }
  }
}
