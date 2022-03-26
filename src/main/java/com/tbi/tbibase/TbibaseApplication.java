package com.tbi.tbibase;

import com.tbi.tbibase.entities.JobFinal;
import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.repository.JobFinalRepository;
import com.tbi.tbibase.repository.JobStartRepository;
import com.tbi.tbibase.repository.WellRepository;
import com.tbi.tbibase.services.JobFinalService;
import com.tbi.tbibase.services.JobStartService;
import com.tbi.tbibase.services.WellService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class TbibaseApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TbibaseApplication.class);

        WellRepository wellRepository = context.getBean(WellRepository.class);
        JobStartRepository jobStartRepository = context.getBean(JobStartRepository.class);
        JobFinalRepository jobFinalRepository = context.getBean(JobFinalRepository.class);
        JobStartService jobStartService = context.getBean(JobStartService.class);
        JobFinalService jobFinalService = context.getBean(JobFinalService.class);
        WellService wellService = context.getBean(WellService.class);

        Well well = wellService.createWell();
        JobStart jobStart = jobStartService.createJob();
        JobFinal jobFinal = jobFinalService.createJob();

        wellRepository.save(well);
        jobStartRepository.save(jobStart);
        jobFinalRepository.save(jobFinal);

        wellRepository.deleteAll();

        context.close();
    }

}
