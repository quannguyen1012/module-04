package com.codegym.service;

import com.codegym.dto.UserDto;
import com.codegym.entity.User;

import java.util.List;

public interface UserService extends IGeneralService<UserDto>{

    List<UserDto> getUsers();

    List<UserDto> getUsersByFullName(String fullname);

    UserDto getUserById(Integer userId);
}

