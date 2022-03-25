package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WELL_ID")
    private Well well;

    public JobStart() {
    }

    public JobStart(int jobNumber, Date startDateOfJob, Time startTimeOfJob, int startDepth, String operator, Well well) {
        this.jobNumber = jobNumber;
        this.startDateOfJob = startDateOfJob;
        this.startTimeOfJob = startTimeOfJob;
        this.startDepth = startDepth;
        this.operator = operator;
        this.well = well;
    }
}
