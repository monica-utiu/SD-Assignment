package com.example.AssignmentTrial1.repository;

import com.example.AssignmentTrial1.entity.Answer;
import com.example.AssignmentTrial1.entity.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface TagRepository extends CrudRepository<Tags,Integer> {
    Tags findByTitle(String title);
}
