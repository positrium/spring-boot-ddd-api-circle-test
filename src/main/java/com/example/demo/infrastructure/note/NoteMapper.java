package com.example.demo.infrastructure.note;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteMapper {

  @Insert("INSERT INTO note (title, content) VALUES (#{title}, #{content})")
  void save(NoteDto noteDto);

  @Select("SELECT * FROM note")
  List<NoteDto> list();
}
