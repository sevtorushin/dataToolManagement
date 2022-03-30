package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.JobFinal;
import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.repository.JobFinalRepository;
import com.tbi.tbibase.repository.JobStartRepository;
import com.tbi.tbibase.repository.WellRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.sql.Time;

@Service
public class JobFinalService {
    private WellRepository wellRepository;
    private JobStartRepository jobStartRepository;
    private JobFinalRepository jobFinalRepository;

    public JobFinalService(WellRepository wellRepository, JobStartRepository jobStartRepository, JobFinalRepository jobFinalRepository) {
        this.wellRepository = wellRepository;
        this.jobStartRepository = jobStartRepository;
        this.jobFinalRepository = jobFinalRepository;
    }

    public JobFinal createJob(){
        Well well = wellRepository.getById(1L);
        JobStart jobStart = jobStartRepository.getById(1L);
        JobFinal jobFinal = new JobFinal(new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),
                1596, new Time(System.currentTimeMillis()), "45-62", "1400-2950",
                97, 49, "норма", jobStart, well);
        return jobFinal;
    }

    public void save(JobFinal jobFinal){
        jobFinalRepository.save(jobFinal);
    }
}
