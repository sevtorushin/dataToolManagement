package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.repository.JobStartRepository;
import com.tbi.tbibase.repository.WellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;

@Service
public class JobStartService {

    private final WellRepository repositoryWell;
    private final JobStartRepository repositoryJobStart;

    @Autowired
    public JobStartService(WellRepository repositoryWell, JobStartRepository repositoryJobStart) {
        this.repositoryWell = repositoryWell;
        this.repositoryJobStart = repositoryJobStart;
    }

    public JobStart createJob(){
        Well well = repositoryWell.getById(1L);
        JobStart jobStart = new JobStart(new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),
                450, "operator1", well);
        jobStart.setJobNumber(1);
        return jobStart;
    }

}
