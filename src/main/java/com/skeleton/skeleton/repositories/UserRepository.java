package com.skeleton.skeleton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.skeleton.skeleton.models.AppUser;
import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

  /**
   * Query for an AppUser by their Id.
   * 
   * @param id
   * @return
   */
  Optional<AppUser> findAppUserById(Long id);

  /**
   * Query for an AppUser by their username.
   * 
   * @param username
   * @return
   */
  Optional<AppUser> findAppUserByUsername(String username);

  /**
   * Query for an AppUser by their email.
   *
   * @param email
   * @return
   */
  Optional<AppUser> findAppUserByEmail(String email);

  /**
   * Query to find all AppUsers
   */
  List<AppUser> findAll();
}