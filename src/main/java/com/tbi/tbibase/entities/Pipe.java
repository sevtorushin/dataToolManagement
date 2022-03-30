package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.*;

@Data
@Entity
@Table(name = "pipe_set")
public class Pipe {
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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "pipes")
    private Set<JobStart> jobStarts = new HashSet<>();

    public Pipe() {
    }

    public Pipe(String serialNumber, Time primaryWorkTime, String note, PipeName pipeName) {
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
        Pipe pipe = (Pipe) o;
        return Objects.equals(id, pipe.id) &&
                Objects.equals(SerialNumber, pipe.SerialNumber) &&
                Objects.equals(PrimaryWorkTime, pipe.PrimaryWorkTime) &&
                Objects.equals(Note, pipe.Note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, SerialNumber, PrimaryWorkTime, Note);
    }
}
