package com.sujwal.core.service;

import java.util.List;

import com.sujwal.core.model.User;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(Long id);

	void saveUser(User user);

	void deleteUser(Long id);
}
