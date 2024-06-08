package com.skeleton.skeleton.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface RoleUserMappingService {
  public ResponseEntity<?> addRoleToUser(Long roleID, Long userID) throws Exception;
}
