package com.cg.service.impl;

import com.cg.dto.UserDto;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IUserService extends IGeneralService<UserDto> {
    List<UserDto> getUsers();

    List<UserDto> getUsersByFullName(String fullname);

    UserDto getUserById(Integer userId);
}
