package com.willy.restCRUD.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
  private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);

  @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
  protected ResponseEntity<ErrorMessage> generalExceptionHandler(Exception e) {
    LOG.error("===>>> EXCEPTION caught :: " + e.getMessage());
    return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
