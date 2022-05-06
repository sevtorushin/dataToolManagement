package com.tbi.tbibase.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

@Data
@Entity
@Table(name = "wells")
public class Well {

    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "WELL_ID", nullable = false, unique = true, table = "wells")
    protected long id;
    private String field;
    private String pad;
    private String wellNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar date;
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date time;
    private String customer;
    private String workingDirectory;

    @OneToMany(mappedBy = "well", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobStart> jobStarts = new ArrayList<>();

    @OneToMany(mappedBy = "well", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobFinal> jobFinals = new ArrayList<>();

//    public Well() {
//    }
//
//    public Well(String field, String pad, String well, Calendar date, Date time, String customer, String workingDirectory) {
//        this.field = field;
//        this.pad = pad;
//        this.well = well;
//        this.date = date;
//        this.time = time;
//        this.customer = customer;
//        this.workingDirectory = workingDirectory;
//    }
//
//    public String getField() {
//        return field;
//    }
//
//    public void setField(String field) {
//        this.field = field;
//    }
//
//    public String getPad() {
//        return pad;
//    }
//
//    public void setPad(String pad) {
//        this.pad = pad;
//    }
//
//    public String getWell() {
//        return well;
//    }
//
//    public void setWell(String well) {
//        this.well = well;
//    }
//
//    public Calendar getDate() {
//        return date;
//    }
//
//    public void setDate(Calendar date) {
//        this.date = date;
//    }
//
//    public Date getTime() {
//        return time;
//    }
//
//    public void setTime(Date time) {
//        this.time = time;
//    }
//
//    public String getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(String customer) {
//        this.customer = customer;
//    }
}
