package com.tbi.tbibase.entities;

import com.tbi.tbibase.repository.WellRepository;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import com.tbi.tbibase.repository.WellRepository;
import org.springframework.context.ConfigurableApplicationContext;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "job_start")
public class JobStart {



    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "JOB_ID", nullable = false, table = "job_start")
    protected long id;

    private int jobNumber;
    private Date startDateOfJob;
    private Time startTimeOfJob;
    private int startDepth;
    private String operator;

    @ManyToOne
    @JoinColumn(name = "WELL_ID")
    private Well well;

    @OneToOne(mappedBy = "jobStart", cascade = CascadeType.ALL)
    private JobFinal jobFinal;

    public JobStart() {
    }

    public JobStart(Date startDateOfJob, Time startTimeOfJob,
                    int startDepth, String operator, Well well) {
        this.startDateOfJob = startDateOfJob;
        this.startTimeOfJob = startTimeOfJob;
        this.startDepth = startDepth;
        this.operator = operator;
        this.well = well;
        setJobNumber(jobNumber);
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }
}
