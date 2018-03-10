package com.example.demo.interfaces.note;

import com.example.demo.domain.model.note.*;
import com.example.demo.domain.service.NoteCreateService;
import com.example.demo.interfaces.AbstractController;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class NoteController extends AbstractController {

  @Autowired
  private NoteCreateService noteCreateService;

  private String json = "";
  private HttpStatus status = HttpStatus.OK;

  /**
   * POST /notes
   * {
   * "title": "hoge",
   * "conetnt": "fuga"
   * }
   * <p>
   * {
   * "note_id": "888888-880888--888888"
   * }
   *
   * @param body
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  @PostMapping(path = "/notes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<String> create(@RequestBody String body) {
    NoteCreateResponseDto noteCreateResponseDto = new NoteCreateResponseDto();

    // サイト名とサイトURLを受け取る
    try {
      NoteCreateDto noteCreateDto = mapper.readValue(body, NoteCreateDto.class);

      NoteTitle noteTitle = new NoteTitle(noteCreateDto.getTitle());
      NoteContent noteContent = new NoteContent(noteCreateDto.getContent());
      Note note = NoteFactory.create(noteTitle, noteContent);
      NoteId noteId = noteCreateService.create(note);

      noteCreateResponseDto.setNoteId(noteId.getValue());

    } catch (IOException | RuntimeException e) {
      log.error("error occurs:", e);

      // 問題があればクライアントエラーとして返す。
      status = HttpStatus.BAD_REQUEST;
      noteCreateResponseDto.setErrorMessage(e.getMessage());

    } catch (Exception e) {
      log.error("error occurs:", e);

      // それ以外の問題はサーバ内エラーとして返す。
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      noteCreateResponseDto.setErrorMessage(e.getMessage());

    }

    try {
      json = mapper.writeValueAsString(noteCreateResponseDto);
    } catch (JsonProcessingException e) {
      log.error("error occurs:", e);
    }

    return new ResponseEntity<>(json, status);
  }
}
