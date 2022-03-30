package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.repository.JobStartRepository;
import com.tbi.tbibase.repository.WellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

@Service
public class JobStartService {

    private final WellRepository wellRepository;
    private final JobStartRepository jobStartRepository;

    @Autowired
    public JobStartService(WellRepository wellRepository, JobStartRepository jobStartRepository) {
        this.wellRepository = wellRepository;
        this.jobStartRepository = jobStartRepository;
    }

    public JobStart createJob(){
        Well well = wellRepository.getById(2L);
        JobStart jobStart = new JobStart(new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),
                450, "Вторушин С.Е.", well);
        jobStart.setJobNumber(1);
        return jobStart;
    }

    public void save(JobStart jobStart){
        jobStartRepository.save(jobStart);
    }

    public Optional<JobStart> getById(long id){
        return jobStartRepository.findById(id);
    }
}
