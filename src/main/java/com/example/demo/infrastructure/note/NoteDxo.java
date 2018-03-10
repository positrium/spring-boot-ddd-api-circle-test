package com.example.demo.infrastructure.note;

import com.example.demo.domain.model.note.Note;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NoteDxo {
  private String id;
  private String title;
  private String content;

  public NoteDxo(Note note){
    this.id = note.getNoteId().getValue();
    this.title = note.getNoteTitle().getValue();
    this.content = note.getNoteContent().getValue();
  }
}
