package com.codegym.cms.model.service.impl;

import com.codegym.cms.model.dto.RoleDto;
import com.codegym.cms.model.entity.Role;
import com.codegym.cms.model.repository.RoleRepository;
import com.codegym.cms.model.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<RoleDto> findAll() {
        Iterable<Role> entities = roleRepository.findAll();
        return StreamSupport.stream(entities.spliterator(), true)
                            .map(entity -> modelMapper.map(entity, RoleDto.class))
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleDto> findById(Long id) {
        Role entity = roleRepository.findById(id).orElse(null);
        return Optional.ofNullable(modelMapper.map(entity, RoleDto.class));
    }

    @Override
    public void save(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        roleRepository.save(role);
    }

    @Override
    public void remove(Long id) {
        roleRepository.deleteById(id);
    }
}
