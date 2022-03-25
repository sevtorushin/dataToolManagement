package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "job_final")
public class JobFinal {

    @Id
    @GenericGenerator(name="gen", strategy="foreign",
            parameters=@Parameter(name="property", value="jobStart"))
    @GeneratedValue(generator = "gen")
    @Column(name = "JOB_ID", nullable = false, table = "job_final")
    private Long id;
    private Date jobComplitionDate;
    private Time jobComplitionTime;
    private int finalDepth;
    private Time circulationTime;
    private String flowRate;
    private String rpm;
    private int shock;
    private int temperature;
    private String note;

    @OneToOne
    @JoinColumn(name = "JOB_ID")
    private JobStart jobStart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WELL_ID")
    private Well well;

    public JobFinal() {
    }

    public JobFinal(Date jobComplitionDate, Time jobComplitionTime, int finalDepth,
                    Time circulationTime, String flowRate, String rpm, int shock,
                    int temperature, String note, JobStart jobStart, Well well) {
        this.jobComplitionDate = jobComplitionDate;
        this.jobComplitionTime = jobComplitionTime;
        this.finalDepth = finalDepth;
        this.circulationTime = circulationTime;
        this.flowRate = flowRate;
        this.rpm = rpm;
        this.shock = shock;
        this.temperature = temperature;
        this.note = note;
        this.jobStart = jobStart;
        this.well = well;
    }
}
