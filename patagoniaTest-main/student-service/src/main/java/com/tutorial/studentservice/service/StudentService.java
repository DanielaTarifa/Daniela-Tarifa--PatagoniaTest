package com.tutorial.studentservice.service;

import com.tutorial.studentservice.entity.Student;
import com.tutorial.studentservice.feignclients.SubjectFeignClient;
import com.tutorial.studentservice.model.Subject;
import com.tutorial.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository subjectRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SubjectFeignClient subjectFeignClient;

    public List<Student> getAll() {
        return subjectRepository.findAll();
    }

    public Student getClientById(int id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Student save(Student client) {
        Student clientNew = subjectRepository.save(client);
        return clientNew;
    }

    public Subject saveLoan(int clientId, Subject loan) {
        loan.setClientId(clientId);
        Subject loanNew = subjectFeignClient.save(loan);
        return loanNew;
    }
}
