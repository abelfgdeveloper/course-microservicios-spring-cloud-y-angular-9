package com.abelfgdeveloper.courses.common.exception.server;

import com.abelfgdeveloper.courses.common.exception.AbelfgDeveloperException;

public class ServerException extends AbelfgDeveloperException {

  private static final long serialVersionUID = 1L;

  private static final int STATUS = 500;

  public ServerException(String message) {
    super(STATUS, message);
  }

  public ServerException(String message, Throwable cause) {
    super(STATUS, message, cause);
  }
}
