package com.cg.service.user;

import com.cg.model.User;
import com.cg.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepo.deleteById(id);
    }
}
