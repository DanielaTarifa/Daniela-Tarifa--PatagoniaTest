package com.tutorial.subjectservice.controller;

import com.tutorial.subjectservice.entity.Subject;
import com.tutorial.subjectservice.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAll() {
        List<Subject> subject = subjectService.getAll();
        if(subject.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(subject);
        //(loans)
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getById(@PathVariable("id") int id) {
        Subject subject = subjectService.getSubjectById(id);
        if(subject == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(subject);
    }

    @PostMapping()
    public ResponseEntity<Subject> save(@RequestBody Subject subject) {
        Subject subjectNew = subjectService.save(subject);
        return ResponseEntity.ok(subjectNew);
    }

    @GetMapping("/byclient/{clientId}")
    public ResponseEntity<List<Subject>> getByClientId(@PathVariable("clientId") int clientId) {
        List<Subject> subject = subjectService.byClientId(clientId);
        if(subject.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(subject);
    }

}
