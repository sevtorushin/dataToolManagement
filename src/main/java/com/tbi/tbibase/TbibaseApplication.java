package com.tbi.tbibase;

import com.tbi.tbibase.entities.*;
import com.tbi.tbibase.repository.JobFinalRepository;
import com.tbi.tbibase.repository.JobStartRepository;
import com.tbi.tbibase.repository.WellRepository;
import com.tbi.tbibase.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class TbibaseApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TbibaseApplication.class);

//        WellService wellService = context.getBean(WellService.class);
        JobStartService jobStartService = context.getBean(JobStartService.class);
//        JobFinalService jobFinalService = context.getBean(JobFinalService.class);
        PipeSetService pipeSetService = context.getBean(PipeSetService.class);

//        Well well = wellService.createWell();
        JobStart jobStart = jobStartService.createJob();
//        JobFinal jobFinal = jobFinalService.createJob();
        PipeSet pipeSet1 = pipeSetService.createPipeSet(2L, "1475");
        pipeSetService.save(pipeSet1);
        jobStart.addPipe(pipeSet1);
        PipeSet pipeSet2 = pipeSetService.createPipeSet(4L, "84516-03");
        pipeSetService.save(pipeSet2);
        jobStart.addPipe(pipeSet2);
        PipeSet pipeSet3 = pipeSetService.createPipeSet(4L, "84516-01");
        pipeSetService.save(pipeSet3);
        jobStart.addPipe(pipeSet3);
        PipeSet pipeSet4 = pipeSetService.createPipeSet(5L, "1768-9");
        pipeSetService.save(pipeSet4);
        jobStart.addPipe(pipeSet4);

//        wellService.save(well);
        jobStartService.save(jobStart);
//        jobFinalService.save(jobFinal);
//        wellService.delete(well);

        context.close();
    }

}
