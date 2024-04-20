package com.skeleton.skeleton.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.skeleton.skeleton.repositories.RoleRepository;
import com.skeleton.skeleton.requestObjects.CreateRoleObj;
import com.skeleton.skeleton.configurations.NotFoundException;
import com.skeleton.skeleton.models.Role;
import java.util.Optional;

@Service
@Component
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  public RoleServiceImpl(
      RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public List<Role> getRoles() {
    return roleRepository.findAll();
  }

  @Override
  public ResponseEntity<?> createRole(final CreateRoleObj roleRequest) {
    boolean nameExists = roleRepository.findRoleByName(roleRequest.getName()).isPresent();

    if (!nameExists) {
      Role newRole = new Role();
      newRole.setName(roleRequest.getName());

      roleRepository.saveAndFlush(newRole);
      return ResponseEntity.status(HttpStatus.CREATED).body("Role Created");
    } else {
      return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("role already exists.");
    }
  }

  @Override
  public Role findRoleById(Long id) throws Exception {
    Optional<Role> maybeRole = roleRepository.findById(id);
    if (maybeRole.isPresent()) {
      Role role = maybeRole.get();
      return role;
    } else {
      throw new NotFoundException("Role not found");
    }
  }

  @Override
  public Role findRoleByName(String name) throws Exception {
    Optional<Role> maybeRole = roleRepository.findRoleByName(name);
    if (maybeRole.isPresent()) {
      Role role = maybeRole.get();
      return role;
    } else {
      throw new NotFoundException("Role not found");
    }
  }

  @Override
  public ResponseEntity<?> deleteRoleById(Long id) throws Exception {
    Optional<Role> maybeRole = roleRepository.findById(id);
    if (maybeRole.isPresent()) {
      Role role = maybeRole.get();
      roleRepository.deleteById(role.getId());
      return ResponseEntity.ok().body("role deleted");
    } else {
      throw new NotFoundException("Role not found");
    }
  }
}
