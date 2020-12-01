package com.abelfgdeveloper.courses.common.api.resource.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponseResource {

  private LocalDateTime timestamp;
  private int status;
  private String error;
  private String message;
  private String detail;
  private List<String> stackTrace;
  private ErrorResponseResource cause;
}
