//package com.example.AssignmentTrial1.controller;
//
//import com.example.AssignmentTrial1.dto.AnswerDTO;
//import com.example.AssignmentTrial1.dto.QuestionDTO;
//import com.example.AssignmentTrial1.service.ContentServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/content")
//public class ContentController {
//    @Autowired
//    ContentServiceImpl contentService;
//
//    @GetMapping(path="/getQuestion/{q_id}")
//    @ResponseBody
//    public QuestionDTO getQuestion(@PathVariable Integer q_id) {
//
//        return contentService.readQuestion(q_id);
//    }
//    @GetMapping(path="getAnswer/{a_id}")
//    @ResponseBody
//    public AnswerDTO getAnswer(@PathVariable Integer a_id) {
//        return contentService.readAnswer(a_id);
//    }
//
//
//
//
//
//}
