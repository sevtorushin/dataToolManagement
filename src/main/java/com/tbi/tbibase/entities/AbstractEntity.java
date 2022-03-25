package com.tbi.tbibase.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEntity {

    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(nullable = false, unique = true)
    protected long id;
}
