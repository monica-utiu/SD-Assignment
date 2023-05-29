package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.entity.Question;
import com.example.AssignmentTrial1.entity.User;
import com.example.AssignmentTrial1.entity.votes.VoteQuestion;
import com.example.AssignmentTrial1.repository.QuestionRepository;
import com.example.AssignmentTrial1.repository.UserRepository;
import com.example.AssignmentTrial1.repository.VoteQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VoteQuestionService implements VoteService<VoteQuestion>{
    @Autowired
    VoteQuestionRepo voteQuestionRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public VoteQuestion createVote(Long userId, Integer contentId, VoteQuestion vote) {
        Optional<User> author = userRepository.findById(userId);
        Optional<Question> question = questionRepository.findById(contentId);
        if(author.isPresent() && question.isPresent()) {
            vote.setVoteId(50);
            vote.setQuestion(question.get());
            vote.setUser(author.get());
            this.voteQuestionRepo.save(vote);
            return vote;
        }
        return null;
    }

    @Override
    public List<VoteQuestion> getAllVotes() {
        return (List<VoteQuestion>) voteQuestionRepo.findAll();
    }

    @Override
    public List<VoteQuestion> getAllVotesOfContent(Integer questionId) {
        List<VoteQuestion> votes = new ArrayList<>();
        voteQuestionRepo.findAll().forEach(v -> {
            if (v.getQuestion().getId().equals(questionId))
                votes.add(v);
        });
        return votes;
    }

    @Override
    public List<VoteQuestion> getAllVotesOfUser(Long userId) {
        List<VoteQuestion> votes = new ArrayList<>();
        voteQuestionRepo.findAll().forEach(v -> {
            if (v.getUser().getUserId().equals(userId))
                votes.add(v);
        });
        return votes;
    }

    @Override
    public List<VoteQuestion> getAllVotesTowardsUser(Long userId) {
        List<VoteQuestion> votes = new ArrayList<>();
        voteQuestionRepo.findAll().forEach(v -> {
            if (Objects.equals(v.getQuestion().getAuthor().getUserId(), userId))
                votes.add(v);
        });
        return votes;
    }

    @Override
    public VoteQuestion readAnswer(Integer id) {
        Optional<VoteQuestion> vote =  voteQuestionRepo.findById(id);
        return vote.orElse(null);
    }

    @Override
    public VoteQuestion updateVote(Integer id, Integer vote) {
        Optional<VoteQuestion> oldVote =  voteQuestionRepo.findById(id);
        if(oldVote.isPresent()) {
            VoteQuestion updateVote = oldVote.get();
            if(!Objects.equals(vote, updateVote.getVote())) {
                updateVote.setVote(vote);
            }
            return voteQuestionRepo.save(updateVote);
        }
        return null;
    }

    @Override
    public void deleteVote(Integer id) {
        voteQuestionRepo.deleteById(id);
    }

}
