package com.example.backend.controller;

import com.example.backend.model.Job;
import com.example.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping("/jobs")
    public Job createJob(@RequestBody Job job) {
        return service.createJob(job);
    }

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/jobs/{id}")
    public Job getJob(@PathVariable Long id) {
        return service.getJob(id);
    }

    @PostMapping("/run-job/{id}")
    public String runJob(@PathVariable Long id) {
        service.runJob(id);
        return "Job started";
    }
}
