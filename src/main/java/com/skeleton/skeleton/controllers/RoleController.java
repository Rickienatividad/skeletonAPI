package com.skeleton.skeleton.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.skeleton.skeleton.services.RoleService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

  @PostMapping(path = "")
  public ResponseEntity<?> createRoleEntity(String name) {
    return roleService.createRole(name);
  }
}
