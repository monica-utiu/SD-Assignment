package com.example.AssignmentTrial1.repository;

import com.example.AssignmentTrial1.dto.UserDTO;
import com.example.AssignmentTrial1.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
