package com.tutorial.studentservice.controller;

import com.tutorial.studentservice.entity.Student;
import com.tutorial.studentservice.model.Subject;
import com.tutorial.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> clients = studentService.getAll();
        if(clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") int id) {
        Student client = studentService.getClientById(id);
        if(client == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(client);
    }

    @PostMapping()//"/addClient"
    public ResponseEntity<Student> save(@RequestBody Student client) {
        Student clientNew = studentService.save(client);
        return ResponseEntity.ok(clientNew);
    }

   /* @GetMapping("/loan/{clientId}")
    public ResponseEntity<List<Loan>> getLoan(@PathVariable("clientId") int clientId) {
        Client client = clientService.getClientById(clientId);
        if(client == null)
            return ResponseEntity.notFound().build();
        List<Client> loan = clientService.getLoan(clientId);
        return ResponseEntity.ok(loan);

    } */

    @PostMapping("/saveloan/{clientId}")
    public ResponseEntity<Subject> saveLoan(@PathVariable("clientId") int clientId, @RequestBody Subject loan) {
        if(studentService.getClientById(clientId) == null)
            return ResponseEntity.notFound().build();
        Subject loanNew = studentService.saveLoan(clientId, loan);
        return ResponseEntity.ok(loan);
    }
}
