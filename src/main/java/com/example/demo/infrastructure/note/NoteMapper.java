package com.example.demo.infrastructure.note;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteMapper {

  @Insert("INSERT INTO note (id, title, content) VALUES (#{id}, #{title}, #{content})")
  void save(NoteDxo noteDxo);

  @Select("SELECT * FROM note")
  List<NoteDxo> list();
}
