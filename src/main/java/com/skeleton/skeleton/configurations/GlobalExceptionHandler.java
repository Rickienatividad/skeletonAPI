package com.skeleton.skeleton.configurations;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NoHandlerFoundException.class)
  public String handleNotFoundError(Exception ex) {
    return "redirect:/yourCustom404page";
  }

  @ExceptionHandler({ NotFoundException.class })
  public final ResponseEntity<String> handleNotFoundException(final NotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}