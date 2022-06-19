package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private java.util.Date startDateOfJob;
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private java.util.Date startTimeOfJob;
    private int startDepth;
    private String operator;

    @ManyToOne
    @JoinColumn(name = "WELL_ID")
    private Well well;

    @OneToOne(mappedBy = "jobStart", cascade = CascadeType.ALL)
    private JobFinal jobFinal;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pipe_has_job_start",
            joinColumns = @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID"),
            inverseJoinColumns = @JoinColumn(name = "PIPE_ID", referencedColumnName = "PIPE_ID"))
    private Set<Pipe> pipes = new HashSet<>();

    public void addPipe(Pipe pipe) {
        pipes.add(pipe);
        pipe.getJobStarts().add(this);
    }

    public void remove(Pipe pipe){
        pipes.remove(pipe);
        pipe.getJobStarts().remove(this);
    }

    @Override
    public String toString() {
        return "JobStart{" +
                "id=" + id +
                ", jobNumber=" + jobNumber +
                ", startDateOfJob=" + startDateOfJob +
                ", startTimeOfJob=" + startTimeOfJob +
                ", startDepth=" + startDepth +
                ", operator='" + operator + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobStart jobStart = (JobStart) o;
        return id == jobStart.id &&
                jobNumber == jobStart.jobNumber &&
                startDepth == jobStart.startDepth &&
                Objects.equals(startDateOfJob, jobStart.startDateOfJob) &&
                Objects.equals(startTimeOfJob, jobStart.startTimeOfJob) &&
                Objects.equals(operator, jobStart.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobNumber, startDateOfJob, startTimeOfJob, startDepth, operator);
    }
}
