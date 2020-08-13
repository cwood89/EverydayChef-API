package com.everydaychef.main.service;

import com.everydaychef.main.model.EndUser;
import com.everydaychef.main.repository.EndUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndUserService {
  @Autowired
  EndUserRepository endUserRepository;

  public EndUser signup(EndUser endUser) {
    return endUserRepository.save(endUser);
  }
}