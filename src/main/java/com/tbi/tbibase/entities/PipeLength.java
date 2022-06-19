package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pipe_change_length")
public class PipeLength {
    @Id
    @GenericGenerator(name="gen", strategy="increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "RECORD_ID", nullable = false, table = "pipe_change_length")
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private java.util.Date changeDateTime;
    private int length;

    @ManyToOne
    @JoinColumn(name = "PIPE_ID")
    private Pipe pipe;

    public PipeLength() {
    }
}
