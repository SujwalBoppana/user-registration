package com.sujwal.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sujwal.core.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
