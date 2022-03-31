package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "equipment_name")
public class EquipmentName {
    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "NAME_ID", nullable = false, table = "equipment_name")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "equipmentName", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipment> equipment = new ArrayList<>();

    public EquipmentName() {
    }

    public EquipmentName(String name) {
        this.name = name;
    }
}
