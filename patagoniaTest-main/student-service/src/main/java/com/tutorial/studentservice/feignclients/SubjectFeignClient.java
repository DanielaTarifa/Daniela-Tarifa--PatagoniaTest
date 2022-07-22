package com.tutorial.studentservice.feignclients;

import com.tutorial.studentservice.model.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "subject-service")
@RequestMapping("/subject")
public interface SubjectFeignClient {

    @PostMapping()
    public Subject save(@RequestBody Subject loan);

    @GetMapping("/byclient/{clientId}")
    public List<Subject> getLoan(@PathVariable("clientId") int clientId);



}
