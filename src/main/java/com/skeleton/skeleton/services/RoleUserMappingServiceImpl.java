package com.skeleton.skeleton.services;

import org.springframework.http.ResponseEntity;

public class RoleUserMappingServiceImpl implements RoleUserMappingService {
  public ResponseEntity<?> addRoleToUser(Long roleID, Long userID) throws Exception {
    return ResponseEntity.ok().body("Role Added to User Successfully.");
  }
}
