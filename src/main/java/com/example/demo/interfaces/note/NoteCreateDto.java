package com.example.demo.interfaces.note;

import lombok.Data;

import java.io.Serializable;

@Data
public class NoteCreateDto implements Serializable {
  private String title;
  private String content;
}
