package com.tbi.tbibase;

import com.tbi.tbibase.entities.*;
import com.tbi.tbibase.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class TbibaseApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TbibaseApplication.class);

        WellService wellService = context.getBean(WellService.class);
        JobStartService jobStartService = context.getBean(JobStartService.class);
//        JobFinalService jobFinalService = context.getBean(JobFinalService.class);
        PipeService pipeService = context.getBean(PipeService.class);

//        Well well = wellService.createWell();
//        JobStart jobStart = jobStartService.createJob();
        Optional<JobStart> jobStartOptional = jobStartService.getById(3L);
        JobStart jobStart = jobStartOptional.get();

        Pipe pipe1 = pipeService.getById(1L).get();
        Pipe pipe2 = pipeService.getById(6L).get();
        Pipe pipe3 = pipeService.getById(7L).get();
        Pipe pipe4 = pipeService.getById(8L).get();
//        JobFinal jobFinal = jobFinalService.createJob();
//        Pipe pipe1 = pipeService.createPipeSet(1L, "1475");
//        pipeService.save(pipe1);
        jobStart.addPipe(pipe1);
//        Pipe pipe2 = pipeService.createPipeSet(4L, "84516-03");
//        pipeService.save(pipe2);
        jobStart.addPipe(pipe2);
//        Pipe pipe3 = pipeService.createPipeSet(4L, "84516-01");
//        pipeService.save(pipe3);
        jobStart.addPipe(pipe3);
//        Pipe pipe4 = pipeService.createPipeSet(5L, "1768-9");
//        pipeService.save(pipe4);
        jobStart.addPipe(pipe4);

//        wellService.save(well);
        jobStartService.save(jobStart);
//        jobFinalService.save(jobFinal);
//        wellService.delete(well);

        context.close();
    }

}
