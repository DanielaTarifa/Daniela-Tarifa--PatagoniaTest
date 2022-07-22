package com.example.studentservice.feignclients;

import com.example.studentservice.model.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "subject-service")
@RequestMapping("/subjects")
public interface SubjectFeignClient {

    @PostMapping("/subjects")
    Subject createSubject(@RequestBody Subject subject);

    @GetMapping("/subjects/bystudent/{studentid}")
     ResponseEntity<Subject> findByStudentId(@PathVariable("studentid") int studentId);

}
