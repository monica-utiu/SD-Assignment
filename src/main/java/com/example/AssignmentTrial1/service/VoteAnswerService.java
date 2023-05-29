package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.entity.votes.VoteAnswer;
import com.example.AssignmentTrial1.entity.votes.VoteQuestion;
import com.example.AssignmentTrial1.repository.AnswerRepository;
import com.example.AssignmentTrial1.repository.UserRepository;
import com.example.AssignmentTrial1.repository.VoteAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VoteAnswerService implements VoteService<VoteAnswer>{
    @Autowired
    private VoteAnswerRepo voteAnswerRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Override
    public VoteAnswer createVote(Long userId, Integer contentId, VoteAnswer vote) {
        Optional<User> author = userRepository.findById(userId);
        Optional<Answer> answer = answerRepository.findById(contentId);
        if(author.isPresent() && answer.isPresent()) {
            vote.setAnswer(answer.get());
            vote.setUser(author.get());
            this.voteAnswerRepo.save(vote);
            return vote;
        }
        return null;
    }

    @Override
    public List<VoteAnswer> getAllVotes() {
        return (List<VoteAnswer>) voteAnswerRepo.findAll();
    }

    @Override
    public List<VoteAnswer> getAllVotesOfContent(Integer questionId) {
        return null;
    }

    @Override
    public List<VoteAnswer> getAllVotesOfUser(Long userId) {
        return null;
    }

    @Override
    public List<VoteAnswer> getAllVotesTowardsUser(Long userId) {
        List<VoteAnswer> votes = new ArrayList<>();
        voteAnswerRepo.findAll().forEach(v -> {
            if (Objects.equals(v.getAnswer().getAuthor().getUserId(), userId))
                votes.add(v);
        });
        return votes;
    }

    @Override
    public VoteAnswer readAnswer(Integer id) {
        Optional<VoteAnswer> vote =  voteAnswerRepo.findById(id);
        return vote.orElse(null);
    }

    @Override
    public VoteAnswer updateVote(Integer id, Integer vote) {
        Optional<VoteAnswer> oldVote =  voteAnswerRepo.findById(id);
        if(oldVote.isPresent()) {
            VoteAnswer updateVote = oldVote.get();
            if(!Objects.equals(vote, updateVote.getVote())) {
                updateVote.setVote(vote);
            }
            return voteAnswerRepo.save(updateVote);
        }
        return null;
    }

    @Override
    public void deleteVote(Integer id) {
        voteAnswerRepo.deleteById(id);
    }


}
