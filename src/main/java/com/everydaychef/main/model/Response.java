package com.everydaychef.main.model;

public class Response {
  public String status;
  public String message;

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

  public Response(String status, String message) {
    this.status = status;
    this.message = message;
  }

}