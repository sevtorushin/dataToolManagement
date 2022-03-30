package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Time;
import java.util.*;

@Data
@Entity
@Table(name = "pipe_set")
public class PipeSet {
    @Id
    @GenericGenerator(name="gen", strategy="increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "PIPE_ID", nullable = false, table = "pipe_set")
    private Long id;
    private String SerialNumber;
    private Time PrimaryWorkTime;
    private String Note;

    @ManyToOne
    @JoinColumn(name = "NAME_ID")
    private PipeName pipeName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "pipeSets")
    private Set<JobStart> jobStarts = new HashSet<>();

    public PipeSet() {
    }

    public PipeSet(String serialNumber, Time primaryWorkTime, String note, PipeName pipeName) {
        SerialNumber = serialNumber;
        PrimaryWorkTime = primaryWorkTime;
        Note = note;
        this.pipeName = pipeName;
    }

    public Set<JobStart> getJobStarts() {
        return jobStarts;
    }

    public void setJobStarts(Set<JobStart> jobStarts) {
        this.jobStarts = jobStarts;
    }

    @Override
    public String toString() {
        return "PipeSet{" +
                "id=" + id +
                ", SerialNumber='" + SerialNumber + '\'' +
                ", PrimaryWorkTime=" + PrimaryWorkTime +
                ", Note='" + Note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PipeSet pipeSet = (PipeSet) o;
        return Objects.equals(id, pipeSet.id) &&
                Objects.equals(SerialNumber, pipeSet.SerialNumber) &&
                Objects.equals(PrimaryWorkTime, pipeSet.PrimaryWorkTime) &&
                Objects.equals(Note, pipeSet.Note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, SerialNumber, PrimaryWorkTime, Note);
    }
}
