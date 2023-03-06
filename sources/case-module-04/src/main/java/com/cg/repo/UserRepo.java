package com.cg.repo;

import com.cg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Long> {
}
