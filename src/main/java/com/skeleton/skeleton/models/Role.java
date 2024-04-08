package com.skeleton.skeleton.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;

@Entity
@Getter
@Setter
@Table(name = "roles")

public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Set<AppUser> users = new HashSet<>();
}
