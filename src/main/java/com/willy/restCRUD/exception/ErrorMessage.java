package com.willy.restCRUD.exception;

import java.text.SimpleDateFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

  private static final SimpleDateFormat FORMATTER =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private String timeStamp;
  private String messeage;

  public ErrorMessage(Exception e) {
    this.messeage = e.getMessage();
    this.timeStamp = FORMATTER.format(System.currentTimeMillis());
  }


}
