package com.example.demo.domain.model.note;

import java.util.List;

public interface NoteRepository {
  void save(Note note);

  List<Note> list();
}
