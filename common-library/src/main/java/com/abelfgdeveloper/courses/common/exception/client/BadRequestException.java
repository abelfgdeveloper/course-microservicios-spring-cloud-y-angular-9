package com.abelfgdeveloper.courses.common.exception.client;

import com.abelfgdeveloper.courses.common.exception.AbelfgDeveloperException;

public class BadRequestException extends AbelfgDeveloperException {

  private static final long serialVersionUID = 1L;

  private static final int STATUS = 400;

  public BadRequestException(String message) {
    super(STATUS, message);
  }

  public BadRequestException(String message, Throwable cause) {
    super(STATUS, message, cause);
  }
}
