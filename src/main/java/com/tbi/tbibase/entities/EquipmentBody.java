package com.tbi.tbibase.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "equipment_body")
public class EquipmentBody {
    @Id
    @GenericGenerator(name="gen", strategy="increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "BODY_ID", nullable = false, table = "equipment_body")
    private Long id;
    private String name;
    private int length;

    @OneToMany(mappedBy = "equipmentBody", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipment> equipment = new ArrayList<>();

    public EquipmentBody() {
    }

    public EquipmentBody(String name, int length) {
        this.name = name;
        this.length = length;
    }
}
