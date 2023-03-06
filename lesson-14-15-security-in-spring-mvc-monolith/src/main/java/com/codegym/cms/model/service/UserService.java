package com.codegym.cms.model.service;

import com.codegym.cms.model.dto.RoleDto;
import com.codegym.cms.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends GeneralService<UserDto> {
    Iterable<UserDto> findAllByRole(RoleDto roleDto);
    Page<UserDto> findAll(Pageable pageable);
    Page<UserDto> findAllByFullNameContaining(String fullName, Pageable pageable);

    boolean isAuthenticated();
}
