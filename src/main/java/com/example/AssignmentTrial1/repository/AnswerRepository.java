package com.example.AssignmentTrial1.repository;

import com.example.AssignmentTrial1.dto.AnswerDTO;
import com.example.AssignmentTrial1.entity.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Integer> {
}
