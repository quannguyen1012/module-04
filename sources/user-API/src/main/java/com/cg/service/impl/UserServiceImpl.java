package com.cg.service.impl;

import com.cg.dto.UserDto;
import com.cg.entity.User;
import com.cg.repository.UserRepo;
import com.cg.repository.UserReposi2;
import com.cg.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserReposi2 userReposi2;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, UserReposi2 userReposi2, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userReposi2 = userReposi2;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<User> findAll() {
        return userReposi2.findAll();
    }

    @Override
    public Optional<UserDto> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userReposi2.save(userDto);
    }


    @Override
    public void remove(Integer id) {
        userReposi2.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersByFullName(String fullname) {
        String likeFullName = "%" + fullname + "%";
        List<User> users = userRepository.findByFullName(likeFullName);
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId).get();
        return modelMapper.map(user, UserDto.class);
    }
}
