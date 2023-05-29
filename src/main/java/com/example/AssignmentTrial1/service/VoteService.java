package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.dto.AnswerDTO;
import com.example.AssignmentTrial1.dto.QuestionAnswersDTO;
import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.entity.votes.VoteQuestion;

import java.util.List;

public interface VoteService<U> {
    U createVote(Long userId, Integer contentId, U vote);
    List<U> getAllVotes();
    List<U> getAllVotesOfContent(Integer contentId);
    List<U> getAllVotesOfUser(Long userId);
    List<U> getAllVotesTowardsUser(Long userId);
    U readAnswer(Integer id);
    U updateVote(Integer id, Integer vote);


    void deleteVote(Integer id);
}
