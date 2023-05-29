package com.example.AssignmentTrial1.repository;

import com.example.AssignmentTrial1.entity.votes.VoteQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteQuestionRepo extends CrudRepository<VoteQuestion, Integer> {
}
