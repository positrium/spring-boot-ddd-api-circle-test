package com.example.demo.application.note;

import com.example.demo.domain.model.note.Note;
import com.example.demo.domain.model.note.NoteRepository;
import com.example.demo.domain.service.NoteCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteCreateServiceImpl implements NoteCreateService {

  @Autowired
  private NoteRepository noteRepository;

  @Override
  public void create(Note note) {
    noteRepository.save(note);
  }
}
