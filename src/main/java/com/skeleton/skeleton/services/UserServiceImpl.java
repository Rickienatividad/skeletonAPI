package com.skeleton.skeleton.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.skeleton.skeleton.models.AppUser;

import com.skeleton.skeleton.configurations.NotFoundException;
import com.skeleton.skeleton.repositories.UserRepository;
import com.skeleton.skeleton.requestObjects.CreateUserObj;
import com.skeleton.skeleton.security.TextEncoder;

@Service
@Component
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(
      UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<AppUser> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public ResponseEntity<?> createUser(final CreateUserObj userReq) {

    // check to see if username or email already exists. if they do, disallow
    // creation of user
    boolean usernameExists = userRepository.findAppUserByUsername(userReq.getUsername()).isPresent();
    boolean emailExists = userRepository.findAppUserByEmail(userReq.getEmail()).isPresent();

    if (!usernameExists && !emailExists) {

      // create a hash of the plain text pw coming from the createUserObj
      String hash = TextEncoder.encode(userReq.getPassword());

      AppUser newUser = new AppUser();
      newUser.setEmail(userReq.getEmail());
      newUser.setPassword(hash);
      newUser.setUsername(userReq.getUsername());

      userRepository.saveAndFlush(newUser);
      return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    } else {
      return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Username or E-mail already taken.");
    }
  }

  @Override
  public AppUser findUserById(Long id) throws Exception {
    Optional<AppUser> maybeUser = userRepository.findAppUserById(id);
    if (maybeUser.isPresent()) {
      AppUser user = maybeUser.get();
      return user;
    } else {
      throw new NotFoundException("User not found");
    }
  }

  @Override
  public AppUser findUserByUsername(String username) throws Exception {
    Optional<AppUser> maybeUser = userRepository.findAppUserByUsername(username);
    if (maybeUser.isPresent()) {
      AppUser user = maybeUser.get();
      return user;
    } else {
      throw new NotFoundException("User not found");
    }
  }

  @Override
  public AppUser findUserByEmail(String email) throws Exception {
    Optional<AppUser> maybeUser = userRepository.findAppUserByUsername(email);
    if (maybeUser.isPresent()) {
      AppUser user = maybeUser.get();
      return user;
    } else {
      throw new NotFoundException("User not found");
    }
  }

  @Override
  public ResponseEntity<?> deleteUserById(Long id) throws Exception {
    Optional<AppUser> maybeUser = userRepository.findAppUserById(id);
    if (maybeUser.isPresent()) {
      AppUser user = maybeUser.get();
      userRepository.deleteById(user.getId());
      return ResponseEntity.ok().body("user deleted");
    } else {
      throw new NotFoundException("User not found");
    }
  }

}