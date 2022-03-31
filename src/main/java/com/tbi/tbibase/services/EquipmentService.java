package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.Equipment;
import com.tbi.tbibase.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentService {
    private EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public void save(Equipment equipment){
        equipmentRepository.save(equipment);
    }

    public Optional<Equipment> getById(long id){
        return equipmentRepository.findById(id);
    }

    public void delete(Equipment equipment){
        equipmentRepository.delete(equipment);
    }
}
