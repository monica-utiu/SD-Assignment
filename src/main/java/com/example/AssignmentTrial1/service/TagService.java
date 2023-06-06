package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.entity.Tags;

import java.util.List;

public interface TagService {
    String createTag(String title);
    List<Tags> getAllTags();
    String readTag(Integer id);
    Tags updateTag(Integer id,Tags title);
    void deleteTag(Integer id);

}
