package com.example.demo.infrastructure.note;

import com.example.demo.DemoApplication;
import com.example.demo.domain.model.note.Note;
import com.example.demo.domain.model.note.NoteContent;
import com.example.demo.domain.model.note.NoteRepository;
import com.example.demo.domain.model.note.NoteTitle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NoteRepositoryImplTest {

  @Autowired
  private JdbcOperations jdbcOperations;

  @Autowired
  private NoteRepository noteRepository;

  @Before
  public void setUp() throws Exception {
    jdbcOperations.execute("delete from note");
  }

  @Test
  public void save_success() {
    NoteTitle noteTitle = new NoteTitle("hoge");
    NoteContent noteContent = new NoteContent("fuga");
    Note note = new Note(noteTitle, noteContent);

    noteRepository.save(note);

    List<Note> list = noteRepository.list();
    Assert.assertTrue(list.size() >= 1);
    Note note1 = list.get(0);

    Assert.assertEquals("hoge", note1.getNoteTitle().getValue());
    Assert.assertEquals("fuga", note1.getNoteContent().getValue());
  }
}
