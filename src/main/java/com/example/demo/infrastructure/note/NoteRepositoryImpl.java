package com.example.demo.infrastructure.note;

import com.example.demo.domain.model.note.Note;
import com.example.demo.domain.model.note.NoteContent;
import com.example.demo.domain.model.note.NoteRepository;
import com.example.demo.domain.model.note.NoteTitle;
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
    NoteDto noteDto = new NoteDto(note);
    noteMapper.save(noteDto);
  }

  @Override
  public List<Note> list() {
    List<Note> list = new ArrayList<>();

    List<NoteDto> dtoList = noteMapper.list();
    for (NoteDto noteDto : dtoList) {
      NoteTitle noteTitle = new NoteTitle(noteDto.getTitle());
      NoteContent noteContent = new NoteContent(noteDto.getContent());
      Note note = new Note(noteTitle, noteContent);

      list.add(note);
    }

    return list;
  }
}
