package com.nbs.marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbs.marketplace.dto.JobRequest;
import com.nbs.marketplace.dto.JobResponse;
import com.nbs.marketplace.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    // Constructor Injection
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Create a new retrofit job
    @PostMapping
    public ResponseEntity<JobResponse> createJob(@RequestBody JobRequest request) {

        JobResponse response = jobService.createJob(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Get all retrofit jobs
    @GetMapping
    public ResponseEntity<java.util.List<JobResponse>> getAllJobs() {

        return ResponseEntity.ok(jobService.getAllJobs());

    }
    // Get retrofit job by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getJobById(@PathVariable Long id) {

    return ResponseEntity.ok(jobService.getJobById(id));

    }   

}