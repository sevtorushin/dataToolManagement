package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.repository.JobStartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobStartService {

    private final JobStartRepository jobStartRepository;

    @Autowired
    public JobStartService(JobStartRepository jobStartRepository) {
        this.jobStartRepository = jobStartRepository;
    }

    public void save(JobStart jobStart){
        jobStartRepository.save(jobStart);
    }

    public Optional<JobStart> getById(long id){
        return jobStartRepository.findById(id);
    }

    public void delete(JobStart jobStart){
        jobStartRepository.delete(jobStart);
    }
}
