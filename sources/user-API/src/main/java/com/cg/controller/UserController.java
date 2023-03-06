package com.cg.controller;

import com.cg.dto.UserDto;
import com.cg.entity.User;
import com.cg.service.impl.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/users")
public class UserController {
    final IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<Iterable<UserDto>> findAllCustomer() {
        List<UserDto> users = (List<UserDto>) userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
//
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateCustomer(@PathVariable Long id, @RequestBody UserDto user) {
        Optional<UserDto> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(userOptional.get().getId());
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<User> deleteCustomer(@PathVariable Long id) {
//        Optional<User> userOptional = userService.findById(id);
//        if (!userOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        userService.remove(id);
//        return new ResponseEntity<>(userOptional.get(), HttpStatus.NO_CONTENT);
//    }
}
