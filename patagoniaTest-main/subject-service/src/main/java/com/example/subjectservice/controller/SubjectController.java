package com.example.subjectservice.controller;


import com.example.subjectservice.entity.Subject;
import com.example.subjectservice.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
        Subject subjectNew = subjectService.createSubject(subject);
        return new ResponseEntity<Subject>(subjectNew,HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Subject>> getSubjects(){
        return ResponseEntity.ok(subjectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getById(@PathVariable("id") int id) {
        Subject subject = subjectService.getSubjectById(id);
        if(subject == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/bystudent/{studentid}")
    public ResponseEntity<?> finByStudentId(@PathVariable("studentid") int studentId){
        return ResponseEntity.ok().body(subjectService.finByStudentId(studentId));
    }





}