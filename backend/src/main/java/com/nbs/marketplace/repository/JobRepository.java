package com.nbs.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nbs.marketplace.entity.Job;

// Repository interface for performing CRUD operations on the Job entity
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
