package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "equipment_set")
public class Equipment {
    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "EQUIPMENT_ID", nullable = false, table = "equipment_set")
    private Long id;
    private String serialNumber;
    private Time primaryWorkTime;
    private String note;

    @ManyToOne
    @JoinColumn(name = "NAME_ID")
    private EquipmentName equipmentName;

    @ManyToOne
    @JoinColumn(name = "BODY_ID")
    private EquipmentBody equipmentBody;
}
