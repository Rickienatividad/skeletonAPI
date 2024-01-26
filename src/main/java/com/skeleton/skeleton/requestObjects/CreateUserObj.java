package com.skeleton.skeleton.requestObjects;

import lombok.Data;

@Data
public class CreateUserObj {
  private String username;

  private String email;

  private String password;
}