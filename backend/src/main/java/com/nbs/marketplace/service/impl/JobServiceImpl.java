package com.nbs.marketplace.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nbs.marketplace.dto.JobRequest;
import com.nbs.marketplace.dto.JobResponse;
import com.nbs.marketplace.entity.Job;
import com.nbs.marketplace.entity.JobStatus;
import com.nbs.marketplace.repository.JobRepository;
import com.nbs.marketplace.service.JobService;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    // Constructor Injection
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Create a new retrofit job
    @Override
    public JobResponse createJob(JobRequest request) {

        // Create a new Job entity
        Job job = new Job();

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setBudget(request.getBudget());
        job.setDeadline(request.getDeadline());

        // Set default values
        job.setStatus(JobStatus.OPEN);
        job.setCreatedAt(LocalDate.now());

        // Save the job
        Job savedJob = jobRepository.save(job);

        // Prepare response
        JobResponse response = new JobResponse();

        response.setId(savedJob.getId());
        response.setTitle(savedJob.getTitle());
        response.setDescription(savedJob.getDescription());
        response.setLocation(savedJob.getLocation());
        response.setBudget(savedJob.getBudget());
        response.setDeadline(savedJob.getDeadline());
        response.setStatus(savedJob.getStatus());
        response.setCreatedAt(savedJob.getCreatedAt());

        return response;
    }

    // Get all retrofit jobs
    @Override
    public List<JobResponse> getAllJobs() {

    List<Job> jobs = jobRepository.findAll();

    return jobs.stream().map(job -> {

        JobResponse response = new JobResponse();

        response.setId(job.getId());
        response.setTitle(job.getTitle());
        response.setDescription(job.getDescription());
        response.setLocation(job.getLocation());
        response.setBudget(job.getBudget());
        response.setDeadline(job.getDeadline());
        response.setStatus(job.getStatus());
        response.setCreatedAt(job.getCreatedAt());

        return response;

    }).toList();
}

    // Get retrofit job by ID
    @Override
    public JobResponse getJobById(Long id) {

    Job job = jobRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));

    JobResponse response = new JobResponse();

    response.setId(job.getId());
    response.setTitle(job.getTitle());
    response.setDescription(job.getDescription());
    response.setLocation(job.getLocation());
    response.setBudget(job.getBudget());
    response.setDeadline(job.getDeadline());
    response.setStatus(job.getStatus());
    response.setCreatedAt(job.getCreatedAt());

    return response;
}

    // Update retrofit job
    @Override
    public JobResponse updateJob(Long id, JobRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // Delete retrofit job
    @Override
    public void deleteJob(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}