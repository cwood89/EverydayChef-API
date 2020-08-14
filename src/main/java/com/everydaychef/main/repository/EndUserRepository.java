package com.everydaychef.main.repository;

import com.everydaychef.main.model.EndUser;

import org.springframework.data.repository.CrudRepository;

public interface EndUserRepository extends CrudRepository<EndUser, Long> {
  EndUser findByUserName(String userName);

  EndUser findByEmail(String email);
}