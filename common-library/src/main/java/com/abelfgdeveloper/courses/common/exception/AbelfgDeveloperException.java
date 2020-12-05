package com.abelfgdeveloper.courses.common.exception;

import lombok.Getter;

@Getter
public class AbelfgDeveloperException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final int status;

  public AbelfgDeveloperException(int status, String message) {
    super(message);
    this.status = status;
  }

  public AbelfgDeveloperException(int status, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
  }
}
