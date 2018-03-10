package com.example.demo.domain.service;

import com.example.demo.domain.model.note.Note;
import com.example.demo.domain.model.note.NoteId;

public interface NoteCreateService {
  NoteId create(Note note);
}
