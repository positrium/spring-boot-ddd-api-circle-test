package com.example.demo.domain.model.note;

import java.util.UUID;

public class NoteFactory {
  public static Note create(NoteTitle noteTitle, NoteContent noteContent) {
    NoteId noteId = new NoteId(UUID.randomUUID().toString());

    return new Note(noteId, noteTitle, noteContent);
  }

}
