package com.tbi.tbibase;

import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.entities.Well;
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

        WellRepository repository = context.getBean(WellRepository.class);
//        Well well1 = new Well("field", "pad", "well", new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),
//                "customer", "directory");
//        repository.save(well1);
        Well well = repository.getById(1L);

        JobStartRepository repository1 = context.getBean(JobStartRepository.class);
        repository1.save(new JobStart(1, new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()),
                450, "operator1", well));

//		repository.deleteAll();
        context.close();
    }

}
