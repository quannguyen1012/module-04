package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.entity.User;
import com.codegym.payload.request.SearchRequest;
import com.codegym.repository.UserRepository;
import com.codegym.service.SecurityService;
import com.codegym.service.UserService;
import com.codegym.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SecurityService securityService;

    @GetMapping({"/all"})
    public ResponseEntity<?> getAll(@RequestHeader("Authorization") final String authToken) {
        ResponseEntity<String> UNAUTHORIZED = getStringResponseEntity(authToken);
        if (UNAUTHORIZED != null) return UNAUTHORIZED;
        List<UserDto> userDtos = userService.getUsers();
        if (userDtos.isEmpty()) {
            return new ResponseEntity<List<UserDto>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id,
                                    @RequestHeader("Authorization") final String authToken) {
        ResponseEntity<String> UNAUTHORIZED = getStringResponseEntity(authToken);
        if (UNAUTHORIZED != null) return UNAUTHORIZED;
        UserDto userDto = userService.getUserById(id);
        if (userDto == null) {
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestBody SearchRequest searchRequest,
                                    @RequestHeader("Authorization") final String authToken) {
        ResponseEntity<String> UNAUTHORIZED = getStringResponseEntity(authToken);
        if (UNAUTHORIZED != null) return UNAUTHORIZED;
        List<UserDto> userDtos = null;
        if (searchRequest.getKeyword() != null && !searchRequest.getKeyword().isEmpty()) {
            userDtos = userService.getUsersByFullName(searchRequest.getKeyword());
            if (userDtos.isEmpty()) {
                return new ResponseEntity<List<UserDto>>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }



    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto,
                                            @RequestHeader("Authorization") final String authToken) {
        ResponseEntity<String> UNAUTHORIZED = getStringResponseEntity(authToken);
        if (UNAUTHORIZED != null) return UNAUTHORIZED;

        UserDto user = userService.getUserById(id);
        if (userDto != null) {
            UserDto userDto1 = new UserDto(userDto.getId(),userDto.getFullname(),userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()), userDto.getEmail(),userDto.getAddress(),
                userDto.getPhone(),userDto.getAvatar(),userDto.getActivated(), userDto.getRememberToken());
            return new ResponseEntity<>(userService.save(userDto1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


//    @PutMapping("/edit/{id}")
//    public ResponseEntity<?> updateCustomer(@PathVariable("id")Integer id, @RequestBody UserDto userDto,
//                                               @RequestHeader("Authorization") final String authToken) {
//        ResponseEntity<String> UNAUTHORIZED = getStringResponseEntity(authToken);
//
//        if (UNAUTHORIZED != null) return UNAUTHORIZED;
//        User user = new User(userDto.getFullname(),userDto.getUsername(),
//                passwordEncoder.encode(userDto.getPassword()), userDto.getEmail(),userDto.getAddress(),
//                userDto.getPhone(),userDto.getAvatar(),userDto.getActivated(), userDto.getRememberToken());
//
//        Optional<User> customerOptional = userService.findById(id);
//        if (!customerOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        user.setId(customerOptional.get().getId());
//        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
//    }



    @DeleteMapping("/remove/{id}")
    public  ResponseEntity<?> delete(@PathVariable Integer id,
                                     @RequestHeader("Authorization") final String authToken){
        ResponseEntity<String> UNAUTHORIZED = getStringResponseEntity(authToken);
        if (UNAUTHORIZED != null) return UNAUTHORIZED;
        UserDto userDto = userService.getUserById(id);
        if (userDto != null) {
            userService.remove(id);
            return new ResponseEntity<>(userDto, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }




    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto,
                                      @RequestHeader("Authorization") final String authToken) {
        ResponseEntity<String> UNAUTHORIZED = getStringResponseEntity(authToken);
        if (UNAUTHORIZED != null) return UNAUTHORIZED;
        UserDto userDto1 = new UserDto(userDto.getFullname(),userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getEmail(),userDto.getAddress(),
                userDto.getPhone(),userDto.getAvatar(),userDto.getActivated(), userDto.getRememberToken());
        return new ResponseEntity<>(userService.save(userDto1), HttpStatus.CREATED);
    }

    private ResponseEntity<String> getStringResponseEntity(String authToken) {
        if (!securityService.isAuthenticated() && !securityService.isValidToken(authToken)) {
            return new ResponseEntity<String>("Responding with unauthorized error. Message - {}",
                                                    HttpStatus.UNAUTHORIZED);
        }
        return null;
    }
}
