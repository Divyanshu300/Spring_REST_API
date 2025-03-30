package com.spring.learn.REST_API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.learn.REST_API.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeEntity , Long> {

}
