package com.example.demo.domain.model.note;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class NoteTest {

  private Note note;

  @Before
  public void eachBefore(){
    note = null;
  }
  @Test
  public void getNoteId() {
    note = NoteFactory.create(new NoteTitle("hoge"), new NoteContent("fuga"));

    String inputPattern = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";

    assertTrue(Pattern.matches(inputPattern, note.getNoteId().getValue()));
  }

  @Test
  public void getNoteTitle() {
    note = NoteFactory.create(new NoteTitle("hoge"), new NoteContent("fuga"));

    assertEquals("fuga", note.getNoteTitle().getValue());
  }

  @Test
  public void getNoteContent() {
    note = NoteFactory.create(new NoteTitle("hoge"), new NoteContent("fuga"));

    assertEquals("fuga", note.getNoteContent().getValue());
  }
}
