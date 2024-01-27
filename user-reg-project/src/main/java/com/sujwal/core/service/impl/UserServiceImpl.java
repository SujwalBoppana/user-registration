package com.sujwal.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujwal.core.model.User;
import com.sujwal.core.repository.UserRepository;
import com.sujwal.core.service.UserService;
import com.sujwal.core.util.Utility;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElse(null);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		Utility.SendEmail(user.getUsername(), user.getEmail());
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
