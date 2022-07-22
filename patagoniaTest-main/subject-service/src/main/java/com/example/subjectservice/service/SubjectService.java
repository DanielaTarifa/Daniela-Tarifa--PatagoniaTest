package com.example.subjectservice.service;

import com.example.subjectservice.entity.Subject;
import com.example.subjectservice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }


    public List<Subject> finByStudentId(int studentId){
        return subjectRepository.findByStudentId(studentId);
    }

    public Subject getSubjectById(int id) {
        return subjectRepository.findById(id).orElse(null);
    }
}
