package com.everydaychef.main.repository;

import com.everydaychef.main.model.Favorite;

import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<Favorite, Long> {

}