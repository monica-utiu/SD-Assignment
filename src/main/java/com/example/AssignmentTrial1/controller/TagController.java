package com.example.AssignmentTrial1.controller;

import com.example.AssignmentTrial1.entity.Tags;
import com.example.AssignmentTrial1.service.TagService;
import com.example.AssignmentTrial1.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tags")
@CrossOrigin(origins = "http://localhost:4200")
public class TagController {
    @Autowired
    TagServiceImpl tagService;
    @GetMapping(path="/getTag/{t_id}")
    @ResponseBody
    public String getTag(@PathVariable Integer t_id) { return tagService.readTag(t_id);}
    @GetMapping(path="/getAllTags")
    @ResponseBody
    public List<Tags> getAllTags() {return tagService.getAllTags();}

    @PostMapping(path="/create")
    @ResponseBody
    public ResponseEntity<Map<String, String>> createTag(@RequestBody String tag) {
        System.out.println("here in controller");
        Map<String, String> response = new HashMap<>();
        tag = tagService.createTag(tag);
        if(tag==null) {
            response = null;
        }
        else
            response.put("title", tag);
        return ResponseEntity.ok(response);
    }
    // i dont need put
    // i dont know if i need delete
    @DeleteMapping(path="delete/{t_id}")
    @ResponseBody
    public void deleteTag(@PathVariable Integer t_id) {
        tagService.deleteTag(t_id);
    }
}
