package com.blogapp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.entities.User;
import com.blogapp.exceptions.ResourceNotFoundExceptuon;
import com.blogapp.payloads.UserDto;
import com.blogapp.repositories.UserRepository;
import com.blogapp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto dtoUser) {
		User user = this.userDtoToUser(dtoUser);
		User savedUser = userRepository.save(user);
		return this.userToUserDto(savedUser);

	}

	@Override
	public UserDto updateUser(UserDto dtoUser, Integer userId) {

		User findById = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundExceptuon("user", "id", userId));

		findById.setName(dtoUser.getName());
		findById.setEmail(dtoUser.getEmail());
		findById.setPassword(dtoUser.getPassword());
		findById.setAbout(dtoUser.getAbout());

		User savedUser = userRepository.save(findById);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundExceptuon("user", "id", userId));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundExceptuon("user", "id", userId));
		userRepository.delete(user);

	}

	private UserDto userToUserDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	private User userDtoToUser(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}

}
