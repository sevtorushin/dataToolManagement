package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pipe_name")
public class PipeName {
    @Id
    @GenericGenerator(name="gen", strategy="increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "NAME_ID", nullable = false, table = "pipe_name")
    private Long id;
    private String Name;

    @OneToMany(mappedBy = "pipeName", cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<Pipe> pipes = new ArrayList<>();

    public PipeName() {
    }

    public PipeName(String name) {
        Name = name;
    }
}
