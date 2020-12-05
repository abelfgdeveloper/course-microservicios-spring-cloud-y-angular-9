package com.abelfgdeveloper.courses.common.exception.client;

import com.abelfgdeveloper.courses.common.exception.AbelfgDeveloperException;

public class NotFoundException extends AbelfgDeveloperException {

  private static final long serialVersionUID = 1L;

  private static final int STATUS = 404;

  public NotFoundException(String message) {
    super(STATUS, message);
  }

  public NotFoundException(String message, Throwable cause) {
    super(STATUS, message, cause);
  }
}
