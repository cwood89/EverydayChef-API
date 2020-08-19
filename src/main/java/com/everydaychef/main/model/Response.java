package com.everydaychef.main.model;

public class Response {
  public String status;
  public String message;
  public EndUserDTO user;

  public Response() {
  }

  public Response(String status, String message, EndUserDTO user) {
    this.status = status;
    this.message = message;
    this.user = user;
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

  public EndUserDTO getUser() {
    return user;
  }

  public void setUser(EndUserDTO user) {
    this.user = user;
  }

}