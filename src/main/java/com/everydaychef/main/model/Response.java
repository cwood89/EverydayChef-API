package com.everydaychef.main.model;

public class Response {
  public String status;
  public String message;
  public Long userId;

  public Response() {
  }

  public Response(String status, String message, Long userId) {
    this.status = status;
    this.message = message;
    this.userId = userId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

}