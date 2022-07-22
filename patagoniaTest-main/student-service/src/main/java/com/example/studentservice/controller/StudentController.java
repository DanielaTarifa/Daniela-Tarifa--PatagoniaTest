package com.example.studentservice.controller;

import com.example.studentservice.entity.Student;
import com.example.studentservice.model.Subject;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentNew = studentService.createStudent(student);
        return new ResponseEntity<Student>(studentNew, HttpStatus.CREATED);
    }


    @PostMapping(value ="/createsubject/{studentId}")
    public ResponseEntity<Subject> createSubject(@PathVariable("studentId") int studentId , @RequestBody Subject subject){
        subject.setStudentId(studentId);
        return ResponseEntity.ok().body(studentService.createSubject(subject));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        if(student == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }


    @GetMapping("/subjectsbystudent/{id}")
    public ResponseEntity<Map<String,Object>> getStudents(@PathVariable("id") int studentId){
        List<Subject> subjects = studentService.getStudents(studentId);
        Map<String,Object> studentMap = new HashMap<>();
        if ( subjects.isEmpty()){
            studentMap.put("El estudiante " + studentId , " No tiene Materias " );
        }
        studentMap.put("El estudiante " + studentId , subjects);
        return ResponseEntity.ok().body(studentMap);
    }

}
