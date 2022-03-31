package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.EquipmentBody;
import com.tbi.tbibase.repository.EquipmentBodyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentBodyService {
    private EquipmentBodyRepository equipmentBodyRepository;

    public EquipmentBodyService(EquipmentBodyRepository equipmentBodyRepository) {
        this.equipmentBodyRepository = equipmentBodyRepository;
    }

    public void save(EquipmentBody equipmentBody) {
        equipmentBodyRepository.save(equipmentBody);
    }

    public Optional<EquipmentBody> getById(long id){
        return equipmentBodyRepository.findById(id);
    }

    public void delete(EquipmentBody equipmentBody) {
        equipmentBodyRepository.delete(equipmentBody);
    }
}
