package com.tbi.tbibase.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "demo", schema = "tbischema")
@Data
public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    protected long id;
    private String name;
    private Date date;
    private Time time;

    public Demo(String name, Date date, Time time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Demo() {
    }
}
