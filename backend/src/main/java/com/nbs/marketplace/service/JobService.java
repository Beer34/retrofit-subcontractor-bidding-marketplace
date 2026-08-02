package com.nbs.marketplace.service;

import java.util.List;

import com.nbs.marketplace.dto.JobRequest;
import com.nbs.marketplace.dto.JobResponse;

// Service interface for managing retrofit jobs
public interface JobService {

    // Create a new retrofit job
    JobResponse createJob(JobRequest request);

    // Get all retrofit jobs
    List<JobResponse> getAllJobs();

    // Get a retrofit job by ID
    JobResponse getJobById(Long id);

    // Update an existing retrofit job
    JobResponse updateJob(Long id, JobRequest request);

    // Delete a retrofit job
    void deleteJob(Long id);

}