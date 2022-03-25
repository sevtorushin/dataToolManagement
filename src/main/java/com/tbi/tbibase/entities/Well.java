package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Well {

    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "WELL_ID", nullable = false, unique = true)
    protected long id;
    private String field;
    private String pad;
    private String well;
    private Date date;
    private Time time;
    private String customer;
    private String workingDirectory;

    @OneToMany(mappedBy = "well", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobStart> jobStarts = new ArrayList<>();

    @OneToMany(mappedBy = "well", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobFinal> jobFinals = new ArrayList<>();

    public Well() {
    }

    public Well(String field, String pad, String well, Date date, Time time, String customer, String workingDirectory) {
        this.field = field;
        this.pad = pad;
        this.well = well;
        this.date = date;
        this.time = time;
        this.customer = customer;
        this.workingDirectory = workingDirectory;
    }
}
