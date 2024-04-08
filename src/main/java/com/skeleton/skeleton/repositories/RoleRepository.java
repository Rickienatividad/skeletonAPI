package com.skeleton.skeleton.repositories;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skeleton.skeleton.models.AppUser;
import com.skeleton.skeleton.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

  /**
   * Query for a Role by Id.
   * 
   * @param id
   * @return
   */
  Optional<Role> findRoleById(Long id);

  /**
   * Query for a Role by its name.
   * 
   * @param name
   * @return
   */
  Optional<Role> findRoleByName(String name);

  /**
   * Query to find all Roles
   */
  List<Role> findAll();

}
