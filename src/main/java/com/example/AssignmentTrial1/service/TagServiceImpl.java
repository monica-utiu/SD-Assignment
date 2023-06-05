package com.example.AssignmentTrial1.service;

import com.example.AssignmentTrial1.entity.Tags;
import com.example.AssignmentTrial1.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    TagRepository tagRepository;

    public TagServiceImpl() {
    }

    @Override
    public String createTag(String title) {
        System.out.println("Title "+ title);
        if(tagRepository.findByTitle(title)==null) {
            Tags tag = new Tags();
            tag.setTitle(title);
            return tagRepository.save(tag).getTitle();
        }
        return null;
    }

    @Override
    public List<String> getAllTags() {
        List<String> tags = new ArrayList<>();
        tagRepository.findAll().forEach(t -> {
            tags.add(t.getTitle());
        }
        );
        return tags;
    }

    @Override
    public String readTag(Integer id) {
        Optional<Tags> tag = tagRepository.findById(id);
        return tag.map(Tags::getTitle).orElse(null);
    }

    @Override
    public Tags updateTag(Integer id, Tags title) {
        title.setTagId(id);
        return tagRepository.save(title);
    }

    @Override
    public void deleteTag(Integer id) {
        tagRepository.deleteById(id);
    }
}
