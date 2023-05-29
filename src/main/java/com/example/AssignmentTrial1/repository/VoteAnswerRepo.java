package com.example.AssignmentTrial1.repository;

import com.example.AssignmentTrial1.entity.votes.VoteAnswer;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface VoteAnswerRepo extends CrudRepository<VoteAnswer, Integer> {
}
