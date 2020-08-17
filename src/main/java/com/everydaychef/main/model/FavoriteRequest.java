package com.everydaychef.main.model;

// import java.util.Optional;

// import com.everydaychef.main.repository.EndUserRepository;

// import org.springframework.beans.factory.annotation.Autowired;

public class FavoriteRequest {
  private Long userId;
  private String recipeId;
  // private EndUser user;

  // @Autowired
  // EndUserRepository endUserRepository;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(String recipeId) {
    this.recipeId = recipeId;
  }

  public FavoriteRequest() {
  }

  public FavoriteRequest(Long userId, String recipeId) {
    // Optional<EndUser> endUser = endUserRepository.findById(userId);
    // this.user = endUser.get();
    this.userId = userId;
    this.recipeId = recipeId;
  }

  // public EndUser getUser() {
  // return user;
  // }

  // public void setUser(EndUser user) {
  // this.user = user;
  // }

}