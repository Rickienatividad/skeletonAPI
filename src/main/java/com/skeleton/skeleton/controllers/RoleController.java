package com.skeleton.skeleton.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.skeleton.skeleton.requestObjects.CreateRoleObj;
import com.skeleton.skeleton.services.RoleService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/roles")
public class RoleController {
  private final RoleService roleService;

  /**
   * 
   * @param roleService
   */
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)

  public ResponseEntity<?> createRoleEntity(@RequestBody CreateRoleObj createRoleObj) {
    return roleService.createRole(createRoleObj);
  }
}
