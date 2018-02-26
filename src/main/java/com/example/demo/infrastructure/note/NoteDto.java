package com.example.demo.infrastructure.note;

import com.example.demo.domain.model.note.Note;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NoteDto {
  private String title;
  private String content;

  public NoteDto(Note note){
    this.title = note.getNoteTitle().getValue();
    this.content = note.getNoteContent().getValue();
  }
}
