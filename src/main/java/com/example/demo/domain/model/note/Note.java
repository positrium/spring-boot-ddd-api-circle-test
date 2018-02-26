package com.example.demo.domain.model.note;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Note {
  private NoteTitle noteTitle;
  private NoteContent noteContent;
}
