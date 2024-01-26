package com.skeleton.skeleton.services;

import com.skeleton.skeleton.models.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.skeleton.skeleton.requestObjects.CreateUserObj;

import java.util.List;

@Service
@Component
public interface UserService {
  public List<AppUser> getUsers();

  public ResponseEntity<?> createUser(CreateUserObj createUserObj);

  public AppUser findUserById(Long id) throws Exception;

  public AppUser findUserByUsername(String username) throws Exception;

  public AppUser findUserByEmail(String email) throws Exception;

  public ResponseEntity<?> deleteUserById(Long id) throws Exception;
}
