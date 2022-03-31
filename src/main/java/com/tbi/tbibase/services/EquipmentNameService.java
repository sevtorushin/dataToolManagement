package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.EquipmentName;
import com.tbi.tbibase.repository.EquipmentNameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentNameService {
    private EquipmentNameRepository equipmentNameRepository;

    public EquipmentNameService(EquipmentNameRepository equipmentNameRepository) {
        this.equipmentNameRepository = equipmentNameRepository;
    }

    public void save(EquipmentName equipmentName){
        equipmentNameRepository.save(equipmentName);
    }

    public Optional<EquipmentName> getById(long id){
        return equipmentNameRepository.findById(id);
    }

    public void delete(EquipmentName equipmentName){
        equipmentNameRepository.delete(equipmentName);
    }
}
