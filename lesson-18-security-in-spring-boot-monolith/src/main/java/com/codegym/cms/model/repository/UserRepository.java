package com.codegym.cms.model.repository;

import com.codegym.cms.model.dto.RoleDto;
import com.codegym.cms.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<User> findAllByRole(RoleDto roleDto);
    User findByUsername(String username);
    Page<User> findAllByFullNameContaining(String fullName, Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT r.name FROM roles r " +
                    "INNER JOIN users_roles ru ON r.id = ru.role_id " +
                    "INNER JOIN users u ON ru.user_id = u.id " +
                    "WHERE u.username = :username")
    List<String> findRolesByUsername(@Param("username") String username);
}
