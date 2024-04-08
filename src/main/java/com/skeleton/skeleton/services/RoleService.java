package com.skeleton.skeleton.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.skeleton.skeleton.models.Role;

@Service
@Component
public interface RoleService {

  public List<Role> getRoles();

  public ResponseEntity<?> createRole(String roleName);

  public Role findRoleById(Long id) throws Exception;

  public Role findRoleByName(String username) throws Exception;

  public ResponseEntity<?> deleteRoleById(Long id) throws Exception;

}
