package com.example.studentservice.service;

import com.example.studentservice.entity.Student;
import com.example.studentservice.feignclients.SubjectFeignClient;
import com.example.studentservice.model.Subject;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SubjectFeignClient subjectFeignClient;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public Subject createSubject(@RequestBody Subject subject){
        return subjectFeignClient.createSubject(subject);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    public List<Subject> getStudents(int studentId){
        //return restTemplate.getForObject("http://localhost:8002/exams/bystudent/"+studentId,List.class);
        return (List<Subject>) subjectFeignClient.finByStudentId(studentId).getBody();
    }


    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

}
