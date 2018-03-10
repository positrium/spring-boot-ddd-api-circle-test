package com.example.demo.infrastructure.note;

import com.example.demo.domain.model.note.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteRepositoryImpl implements NoteRepository {

  @Autowired
  private NoteMapper noteMapper;

  @Override
  public void save(Note note) {
    NoteDxo noteDxo = new NoteDxo(note);
    noteMapper.save(noteDxo);
  }

  @Override
  public List<Note> list() {
    List<Note> list = new ArrayList<>();

    List<NoteDxo> dtoList = noteMapper.list();
    for (NoteDxo noteDxo : dtoList) {
      NoteId noteId = new NoteId(noteDxo.getId());
      NoteTitle noteTitle = new NoteTitle(noteDxo.getTitle());
      NoteContent noteContent = new NoteContent(noteDxo.getContent());
      Note note = new Note(noteId, noteTitle, noteContent);

      list.add(note);
    }

    return list;
  }
}
