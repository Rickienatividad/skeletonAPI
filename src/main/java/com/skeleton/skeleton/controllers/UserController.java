package com.skeleton.skeleton.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.skeleton.skeleton.models.AppUser;

import com.skeleton.skeleton.requestObjects.CreateUserObj;
import com.skeleton.skeleton.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
// @AutoConfiguration
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  /**
   * 
   * @param userService
   */

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> createAppUser(@RequestBody CreateUserObj createUserObj) {
    return userService.createUser(createUserObj);
  }

  @GetMapping("")
  public List<AppUser> getUsers() {
    return userService.getUsers();
  }

  @GetMapping("/{id}")
  public AppUser findUserById(@PathVariable Long id) throws Exception {
    return userService.findUserById(id);
  }

  @GetMapping("/{email}")
  public AppUser findUserById(@PathVariable String email) throws Exception {
    return userService.findUserByEmail(email);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUserById(@PathVariable Long id) throws Exception {
    return userService.deleteUserById(id);
  }
}