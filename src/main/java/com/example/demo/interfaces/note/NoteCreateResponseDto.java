package com.example.demo.interfaces.note;

import com.example.demo.interfaces.AbstractResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NoteCreateResponseDto extends AbstractResponseDto {
  private String noteId;
}
