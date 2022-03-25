package com.tbi.tbibase;

import com.tbi.tbibase.entities.JobFinal;
import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.repository.JobFinalRepository;
import com.tbi.tbibase.repository.JobStartRepository;
import com.tbi.tbibase.repository.WellRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class TbibaseApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TbibaseApplication.class);

        WellRepository repositoryWell = context.getBean(WellRepository.class);
        JobStartRepository repositoryJobStart = context.getBean(JobStartRepository.class);
        JobFinalRepository repositoryJobFinal = context.getBean(JobFinalRepository.class);

        Well well = new Well("field", "pad", "well", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),
                "customer", "directory");
        System.out.println(well);
        JobStart jobStart = new JobStart(1, new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),
                450, "operator1", well);
        System.out.println(jobStart);
        JobFinal jobFinal = new JobFinal(new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),
                1000, new Time(System.currentTimeMillis()), "40-65", "1350-2900",
                65, 51, "norm", jobStart, well);

        repositoryWell.save(well);
        System.out.println(well);

        repositoryJobStart.save(jobStart);
        System.out.println(jobStart);

        System.out.println(jobFinal);
        repositoryJobFinal.save(jobFinal);
        System.out.println(jobFinal);

        context.close();
    }

}
