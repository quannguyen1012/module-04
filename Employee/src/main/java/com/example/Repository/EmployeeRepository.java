package com.example.Repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * from employees where branch = :id")
    List<Employee> findAllByBranch(@Param(value = "id") Long id);
    List<Employee> findByOrderByAgeAsc();

}
